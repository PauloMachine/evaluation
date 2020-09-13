import React, { useState, useRef, useCallback, useEffect } from 'react';
import { FormHandles } from '@unform/core';
import { TiEdit } from 'react-icons/ti';
import * as Yup from 'yup';

import api from '../../services/api';
import { setSituationId, getSituationId } from '../../services/storage';
import getValidationErrors from '../../utils/getValidationErrors';

import Navbar from '../../components/Navbar';
import Card from '../../components/Card';

import {
   RContainer,
   RCol,
   RRow,
   RTable,
   Tbody,
   Td,
   Th,
   Thead,
   Tr,
   RForm,
   RButton,
   RInput,
   RModalFooter,
   RModalHeader,
   RModalBody,
   RModal,
} from './styles';

interface ConfiguracaoFormData {
   amount_notification: number;
}

const Configuracoes: React.FC = () => {
   const formRef = useRef<FormHandles>(null);
   const [configuracoes, setConfiguracoes] = useState();
   const [loading, setLoading] = useState(false);
   const [modal, setModal] = useState(false);
   const toggle = () => setModal(!modal);

   async function getConfiguracoes() {
      await setLoading(true);
      await api.get('/situations').then(response => {
         setConfiguracoes(response.data);
         setLoading(false);
      });
   }

   useEffect(() => {
      getConfiguracoes();
   }, []);

   const handleSubmit = useCallback(async (data: ConfiguracaoFormData) => {
      try {
         formRef.current?.setErrors({});

         const schema = Yup.object().shape({
            amount_notification: Yup.number()
               .required('É necessário informar a pedra do round!')
               .min(1, 'A notificação deve ser maior que 0!'),
         });

         await schema.validate(data, { abortEarly: false });

         await setLoading(true);

         await api.put('situations', {
            situations: [
               {
                  id: Number(getSituationId()),
                  amount_notification: Number(data.amount_notification),
               },
            ],
         });

         await setModal(false);
         getConfiguracoes();
         setLoading(false);
      } catch (err) {
         if (err instanceof Yup.ValidationError) {
            const errors = getValidationErrors(err);

            formRef.current?.setErrors(errors);
         }
      }
   }, []);
   return (
      <RContainer>
         <Navbar />
         <RRow>
            <RCol xl="12">
               <Card title="Configuração das notificações" loading={loading}>
                  <RTable responsive>
                     <Thead>
                        <Tr>
                           <Th>Id</Th>
                           <Th>Sequência</Th>
                           <Th>Limite</Th>
                           <Th>Opção</Th>
                        </Tr>
                     </Thead>
                     <Tbody>
                        {configuracoes
                           ? configuracoes.map((config: any) => (
                                <Tr key={config?.id}>
                                 <Td>{Number(config?.id)}</Td>
                                 <Td>{config?.description}</Td>
                                 <Td>{config?.amount_notification}</Td>
                                 <Td>
                                      <RButton
                                       type="submit"
                                       background="#006edd"
                                       onClick={async () => {
                                            await setSituationId(config?.id);
                                            await setModal(true);
                                         }}
                                    >
                                       <TiEdit size={25} color="#fff" />
                                       Editar
                                      </RButton>
                                   </Td>
                              </Tr>
                             ))
                           : null}
                     </Tbody>
                  </RTable>
               </Card>
            </RCol>
         </RRow>
         <RModal isOpen={modal} toggle={toggle}>
            <RModalHeader toggle={toggle}>Edição da notificação</RModalHeader>
            <RModalBody>
               <RForm ref={formRef} onSubmit={handleSubmit}>
                  <RInput
                     name="amount_notification"
                     icon={TiEdit}
                     placeholder="Limite para notificar"
                     autoComplete="off"
                  />
                  <RButton type="submit" background="#006edd" loading={loading}>
                     Editar
                  </RButton>
               </RForm>
            </RModalBody>
            <RModalFooter />
         </RModal>
      </RContainer>
   );
};

export default Configuracoes;

/* eslint-disable @typescript-eslint/explicit-function-return-type */
import React, { useState } from 'react';

import Card from '../Card';

import { RButton, RTable, Tbody, Td, Th, Thead, Tr } from './styles';

const SequenceOnClick: React.FC = () => {
   const [preto, setPreto] = useState(0);
   const [vermelho, setVermelho] = useState(0);
   const [par, setPar] = useState(0);
   const [impar, setImpar] = useState(0);
   const [baixa, setBaixa] = useState(0);
   const [alta, setAlta] = useState(0);

   function handleSubmit(tipo: string) {
      if (tipo === 'preto') {
         setPreto(state => state + 1);
         setVermelho(0);
      } else if (tipo === 'vermelho') {
         setVermelho(state => state + 1);
         setPreto(0);
      } else if (tipo === 'par') {
         setPar(state => state + 1);
         setImpar(0);
      } else if (tipo === 'impar') {
         setImpar(state => state + 1);
         setPar(0);
      } else if (tipo === 'baixa') {
         setBaixa(state => state + 1);
         setAlta(0);
      } else if (tipo === 'alta') {
         setAlta(state => state + 1);
         setBaixa(0);
      }
   }

   function handleClear() {
      setVermelho(0);
      setPreto(0);
      setImpar(0);
      setPar(0);
      setAlta(0);
      setBaixa(0);
   }

   return (
      <Card title="Sequência">
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('preto')}>
                        Preto
                     </button>
                  </Th>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('vermelho')}>
                        Vermelho
                     </button>
                  </Th>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('par')}>
                        Par
                     </button>
                  </Th>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('impar')}>
                        Impar
                     </button>
                  </Th>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('baixa')}>
                        Baixa
                     </button>
                  </Th>
                  <Th>
                     <button type="submit" onClick={() => handleSubmit('alta')}>
                        Alta
                     </button>
                  </Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{preto}</Td>
                  <Td>{vermelho}</Td>
                  <Td>{par}</Td>
                  <Td>{impar}</Td>
                  <Td>{baixa}</Td>
                  <Td>{alta}</Td>
               </Tr>
            </Tbody>
         </RTable>
         <RButton type="submit" onClick={() => handleClear()}>
            Limpar
         </RButton>
      </Card>
   );
};

export default SequenceOnClick;

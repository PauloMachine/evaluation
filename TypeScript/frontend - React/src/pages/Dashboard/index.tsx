/* eslint-disable no-nested-ternary */
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable prefer-const */
/* eslint-disable @typescript-eslint/explicit-function-return-type */
import React, { useCallback, useState, useRef } from 'react';
import { GiGlassBall } from 'react-icons/gi';
import { FormHandles } from '@unform/core';
import * as Yup from 'yup';

import {
   setGamerId,
   getGamerId,
   setRoundId,
   getRoundId,
   setStoneId,
   getStoneId,
   setRoundHistoric,
   getRoundHistoric,
   removeStorage,
} from '../../services/storage';

import api from '../../services/api';
import getValidationErrors from '../../utils/getValidationErrors';
import stones from '../../utils/stones.json';
import clearInput from '../../utils/cleanInput';

import Navbar from '../../components/Navbar';
import Board from '../../components/Board';
import Card from '../../components/Card';
import Sequence from '../../components/Sequence';

import {
   RButton,
   RCenter,
   RForm,
   RInput,
   RCol,
   RContainer,
   RRow,
   RText,
   RTextInformation,
   RRowHistoric,
   RCenterHistoric,
   RColHistoric,
   RModal,
   RModalBody,
   RModalHeader,
   RModalFooter,
} from './styles';

interface DashboardFormData {
   stone: number;
}

const Dashboard: React.FC = () => {
   const formRef = useRef<FormHandles>(null);
   const [loading, setLoading] = useState(false);
   const [modal, setModal] = useState(false);
   const [disabled, setDisabled] = useState(true);
   const toggle = () => setModal(!modal);
   const [sequence, setSequence] = useState([
      {
         situation_id: 0,
         notification: 0,
         situation: {
            amount_notification: 0,
            active: false,
         },
      },
   ]);
   const [historic, setHistoric] = useState([
      {
         roundHistoric: 0,
         stoneHistoric: 0,
         corHistoric: '',
      },
   ]);


   // Função responsavel por criar o game
   async function handleCreateGamer() {
      const response = await api.post('gamer', {
         date: new Date(),
      });

      const { id } = response.data;

      setGamerId(id);
      setDisabled(false);
   }

   // Função responsavel por abrir modal no ultimo indice do array
   async function handleClick(round: any) {
      if (round === historic.length - 1) {
         setModal(!modal);
      }
   }

   const handleSubmit = useCallback(async (data: DashboardFormData) => {
      try {
         formRef.current?.setErrors({});

         const schema = Yup.object().shape({
            stone: Yup.number()
               .required('É necessário informar a pedra do round!')
               .min(1, 'A pedra deve ser maior que 0!')
               .max(36, 'A pedra deve ser menor ou igual à 36!'),
         });

         await schema.validate(data, { abortEarly: false });

         await setLoading(true);

         // Seta a pedra do round
         await setStoneId(data.stone);

         // Inicia o round
         const response = await api.post('round', {
            gamer_id: Number(getGamerId()),
            stone_id: Number(getStoneId()),
         });

         const { round, sequenciesGamer } = response.data;

         // Seta a sequencia
         await setSequence(sequenciesGamer);

         // Seta o numero do round
         await setRoundId(round.id);

         // Seta o numero do round do historic (contador)
         await setRoundHistoric();

         // Seta a cor da pedra
         const stoneColor = stones.filter(stone => stone.id === Number(getStoneId()));

         // Atualiza o historico do round
         await setHistoric(state => [
            ...state,
            {
               roundHistoric: Number(getRoundHistoric()),
               stoneHistoric: Number(getStoneId()),
               corHistoric: String(stoneColor[0].cor),
            },
         ]);

         // Criado função para limpar o input
         clearInput('inputStone');
         await setLoading(false);
      } catch (err) {
         if (err instanceof Yup.ValidationError) {
            const errors = getValidationErrors(err);

            formRef.current?.setErrors(errors);
         }
      }
   }, []);

   const handleSubmitEdit = useCallback(async (data: DashboardFormData) => {
      try {
         formRef.current?.setErrors({});

         const schema = Yup.object().shape({
            stone: Yup.number()
               .required('É necessário informar a pedra do round!')
               .min(1, 'A pedra deve ser maior que 0!')
               .max(36, 'A pedra deve ser menor ou igual à 36!'),
         });

         await schema.validate(data, { abortEarly: false });

         // Seta a pedra do round
         setStoneId(data.stone);

         await setLoading(true);

         // Inicia o edit do round
         const response = await api.put('round', {
            gamer_id: Number(getGamerId()),
            round_id: Number(getRoundId()),
            stone_id: Number(getStoneId()),
         });

         const { round, sequenciesGamer } = response.data;

         // Seta o numero do round
         await setRoundId(round.id);

         // Seta a sequencia
         await setSequence(sequenciesGamer);

         // Seta a cor da pedra
         const stoneColor = stones.filter(stone => stone.id === Number(getStoneId()));

         // Seta novo historico
         await setHistoric(state => [
            ...state.slice(0, state.length - 1),
            {
               roundHistoric: Number(getRoundHistoric()),
               stoneHistoric: Number(getStoneId()),
               corHistoric: String(stoneColor[0].cor),
            },
         ]);

         await setLoading(false);

         await setModal(false);
      } catch (err) {
         if (err instanceof Yup.ValidationError) {
            const errors = getValidationErrors(err);

            formRef.current?.setErrors(errors);
         }
      }
   }, []);

   // Função responsavel por detetar o game
   async function handleDeleteGamer() {
      await api.delete('gamer');
      await setDisabled(true);
      await removeStorage();
      await setSequence([
         {
            situation_id: 0,
            notification: 0,
            situation: {
               amount_notification: 0,
               active: false,
            },
         },
      ]);
      await setHistoric([
         {
            roundHistoric: 0,
            stoneHistoric: 0,
            corHistoric: '',
         },
      ]);
   }

   return (
      <RContainer>
         <Navbar />
         <RRow>
            <RCol xl="6">
               <RCenter>
                  <RButton background="#006edd" type="submit" onClick={() => handleCreateGamer()}>
                     NOVO JOGO
                  </RButton>
                  <RForm ref={formRef} onSubmit={handleSubmit}>
                     <RInput
                        id="inputStone"
                        name="stone"
                        icon={GiGlassBall}
                        placeholder="Pedra sorteada"
                        autoComplete="off"
                        disabled={disabled}
                        readOnly={disabled}
                     />
                     <RButton type="submit" loading={loading}>
                        MARCAR
                     </RButton>
                  </RForm>
                  <RButton background="#971D24" type="submit" onClick={() => handleDeleteGamer()}>
                     ENCERRAR JOGO
                  </RButton>
               </RCenter>
               <RColHistoric xl="12">
                  <Card title="Histórico">
                     <RRowHistoric>
                        {historic
                           .slice(-10)
                           .reverse()
                           .map(item =>
                              item.roundHistoric !== 0 ? (
                                 <RColHistoric
                                    key={item.roundHistoric}
                                    backgroundcolor={
                                       item.corHistoric === 'preto' ? 'rgba(0, 0, 0, 0.5)' : 'rgba(255, 0, 0, 0.5)'
                                    }
                                    border
                                    onClick={() => handleClick(item.roundHistoric)}
                                    style={
                                       item.roundHistoric === historic.length - 1
                                          ? { cursor: 'pointer', borderColor: '#ffb600' }
                                          : null
                                    }
                                 >
                                    <RTextInformation>{`ROUND ${item.roundHistoric}`}</RTextInformation>
                                    <RCenterHistoric>
                                       <RText>{item.stoneHistoric}</RText>
                                    </RCenterHistoric>
                                 </RColHistoric>
                              ) : historic.length <= 1 ? (
                                 <RColHistoric>
                                    <RCenterHistoric>
                                       <RTextInformation>Não há dados para serem listados!</RTextInformation>
                                    </RCenterHistoric>
                                 </RColHistoric>
                              ) : null,
                           )}
                     </RRowHistoric>
                  </Card>
               </RColHistoric>
               <Board />
            </RCol>
            <RCol xl="6">
               <Sequence sequence={sequence} />
            </RCol>
         </RRow>
         <RModal isOpen={modal} toggle={toggle}>
            <RModalHeader toggle={toggle}>Edição da marcação</RModalHeader>
            <RModalBody>
               <RForm ref={formRef} onSubmit={handleSubmitEdit}>
                  <RInput name="stone" icon={GiGlassBall} placeholder="Pedra sorteada" autoComplete="off" />
                  <RButton type="submit" loading={loading}>
                     MARCAR
                  </RButton>
               </RForm>
            </RModalBody>
            <RModalFooter />
         </RModal>
      </RContainer>
   );
};

export default Dashboard;

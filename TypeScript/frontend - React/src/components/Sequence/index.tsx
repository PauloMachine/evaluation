/* eslint-disable react-hooks/exhaustive-deps */
import React, { useEffect } from 'react';

import activeNotification from '../../utils/activeNotification';
import Card from '../Card';

import { RTable, Tbody, Td, Th, Thead, Tr } from './styles';

interface SequenceArrayProps {
   sequence: Array<SequenceObjectProps>;
}

interface SequenceObjectProps {
   situation_id: number;
   notification: number;
   situation: {
      amount_notification: number;
      active: boolean;
   };
}

const Sequence: React.FC<SequenceArrayProps> = ({ sequence }) => {
   const impar = sequence?.filter(seq => seq.situation_id === 1);
   const par = sequence?.filter(seq => seq.situation_id === 2);
   const preto = sequence?.filter(seq => seq.situation_id === 3);
   const vermelho = sequence?.filter(seq => seq.situation_id === 4);
   const pequena = sequence?.filter(seq => seq.situation_id === 5);
   const grande = sequence?.filter(seq => seq.situation_id === 6);
   const duzia1 = sequence?.filter(seq => seq.situation_id === 7);
   const duzia2 = sequence?.filter(seq => seq.situation_id === 8);
   const duzia3 = sequence?.filter(seq => seq.situation_id === 9);
   const coluna1 = sequence?.filter(seq => seq.situation_id === 10);
   const coluna2 = sequence?.filter(seq => seq.situation_id === 11);
   const coluna3 = sequence?.filter(seq => seq.situation_id === 12);

   useEffect(() => {
      if (impar[0]?.notification >= impar[0]?.situation?.amount_notification && impar[0]?.situation?.active === true) {
         activeNotification('Impar');
      }
      if (par[0]?.notification >= par[0]?.situation?.amount_notification && par[0]?.situation?.active === true) {
         activeNotification('Par');
      }
      if (preto[0]?.notification >= preto[0]?.situation?.amount_notification && preto[0]?.situation?.active === true) {
         activeNotification('Preto');
      }
      if (
         vermelho[0]?.notification >= vermelho[0]?.situation?.amount_notification &&
         vermelho[0]?.situation?.active === true
      ) {
         activeNotification('Vermelho');
      }
      if (
         pequena[0]?.notification >= pequena[0]?.situation?.amount_notification &&
         pequena[0]?.situation?.active === true
      ) {
         activeNotification('Pequeno');
      }
      if (
         grande[0]?.notification >= grande[0]?.situation?.amount_notification &&
         grande[0]?.situation?.active === true
      ) {
         activeNotification('Grande');
      }
      if (
         duzia1[0]?.notification >= duzia1[0]?.situation?.amount_notification &&
         duzia1[0]?.situation?.active === true
      ) {
         activeNotification('Duzia 1');
      }
      if (
         duzia2[0]?.notification >= duzia2[0]?.situation?.amount_notification &&
         duzia2[0]?.situation?.active === true
      ) {
         activeNotification('Duzia 2');
      }
      if (
         duzia3[0]?.notification >= duzia3[0]?.situation?.amount_notification &&
         duzia3[0]?.situation?.active === true
      ) {
         activeNotification('Duzia 3');
      }
      if (
         coluna1[0]?.notification >= coluna1[0]?.situation?.amount_notification &&
         coluna1[0]?.situation?.active === true
      ) {
         activeNotification('Coluna 1');
      }
      if (
         coluna2[0]?.notification >= coluna2[0]?.situation?.amount_notification &&
         coluna2[0]?.situation?.active === true
      ) {
         activeNotification('Coluna 2');
      }
      if (
         coluna3[0]?.notification >= coluna3[0]?.situation?.amount_notification &&
         coluna3[0]?.situation?.active === true
      ) {
         activeNotification('Coluna 3');
      }
   }, [sequence]);

   return (
      <Card title="Sequência">
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>Impar</Th>
                  <Th>Par</Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{impar[0]?.notification || 0}</Td>
                  <Td>{par[0]?.notification || 0}</Td>
               </Tr>
            </Tbody>
         </RTable>
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>Preto</Th>
                  <Th>Vermelho</Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{preto[0]?.notification || 0}</Td>
                  <Td>{vermelho[0]?.notification || 0}</Td>
               </Tr>
            </Tbody>
         </RTable>
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>Pequena</Th>
                  <Th>Grande</Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{pequena[0]?.notification || 0}</Td>
                  <Td>{grande[0]?.notification || 0}</Td>
               </Tr>
            </Tbody>
         </RTable>
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>Duzia 1</Th>
                  <Th>Duzia 2</Th>
                  <Th>Duzia 3</Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{duzia1[0]?.notification || 0}</Td>
                  <Td>{duzia2[0]?.notification || 0}</Td>
                  <Td>{duzia3[0]?.notification || 0}</Td>
               </Tr>
            </Tbody>
         </RTable>
         <RTable responsive>
            <Thead>
               <Tr>
                  <Th>Coluna 1</Th>
                  <Th>Coluna 2</Th>
                  <Th>Coluna 3</Th>
               </Tr>
            </Thead>
            <Tbody>
               <Tr>
                  <Td>{coluna1[0]?.notification || 0}</Td>
                  <Td>{coluna2[0]?.notification || 0}</Td>
                  <Td>{coluna3[0]?.notification || 0}</Td>
               </Tr>
            </Tbody>
         </RTable>
      </Card>
   );
};

export default Sequence;

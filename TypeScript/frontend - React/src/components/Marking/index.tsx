import React, { useRef, useCallback, useState } from 'react';
import { GiGlassBall } from 'react-icons/gi';
import { FormHandles } from '@unform/core';
import * as Yup from 'yup';

import api from '../../services/api';
import getValidationErrors from '../../utils/getValidationErrors';

import Card from '../Card';

import { RButton, RCenter, RForm, RInput } from './styles';

interface DashboardFormData {
   stone: string;
}

const Marking: React.FC = () => {
   const formRef = useRef<FormHandles>(null);

   const handleSubmit = useCallback(async (data: DashboardFormData) => {
      try {
         formRef.current?.setErrors({});

         const schema = Yup.object().shape({
            stone: Yup.string().required('É necessário informar a pedra do round!'),
         });

         await schema.validate(data, { abortEarly: false });

         // const response = await api.post('gamer', {
         //    date: new Date(),
         // });
      } catch (err) {
         if (err instanceof Yup.ValidationError) {
            const errors = getValidationErrors(err);

            formRef.current?.setErrors(errors);
         }
      }
   }, []);

   return (
      <Card title="Marcação">
         <RCenter>
            <RForm ref={formRef} onSubmit={handleSubmit}>
               <RInput name="stone" icon={GiGlassBall} placeholder="Pedra sorteada" autoComplete="off" />
               <RButton type="submit">MARCAR</RButton>
            </RForm>
         </RCenter>
      </Card>
   );
};

export default Marking;

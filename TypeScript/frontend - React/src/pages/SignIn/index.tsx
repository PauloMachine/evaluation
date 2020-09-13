import React, { useState, useRef, useCallback } from 'react';
import { FiUser, FiLock } from 'react-icons/fi';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import * as Yup from 'yup';

import { toast } from 'react-toastify';
import { useAuth } from '../../hooks/auth';
import getValidationErrors from '../../utils/getValidationErrors';

import Input from '../../components/Input';
import Button from '../../components/Button';

import rouletteImg from '../../assets/Roulette.png';

import { Container, Content, Background } from './styles';

interface SignInFormData {
   username: string;
   password: string;
}

const SignIn: React.FC = () => {
   const formRef = useRef<FormHandles>(null);
   const [loading, setLoading] = useState(false);

   const { signIn } = useAuth();

   const handleSubmit = useCallback(
      async (data: SignInFormData) => {
         try {
            formRef.current?.setErrors({});

            const schema = Yup.object().shape({
               username: Yup.string().required('O usuário é obrigatório'),
               password: Yup.string().required('A senha é obrigatória'),
            });

            await schema.validate(data, { abortEarly: false });

            setLoading(true);
            await signIn({
               username: data.username,
               password: data.password,
            })
            setLoading(false);
         } catch (err) {
            if (err instanceof Yup.ValidationError) {
               const errors = getValidationErrors(err);

               formRef.current?.setErrors(errors);

               return;
            }

            toast.error('Ocorreu um erro ao fazer login, cheque as credenciais.');
            setLoading(false);
         }
      },
      [signIn],
   );

   return (
      <Container>
         <Content>
            <img src={rouletteImg} alt="Roulette" />
            <Form ref={formRef} onSubmit={handleSubmit}>
               <h1>Faça seu login</h1>

               <Input name="username" icon={FiUser} placeholder="Usuário" />
               <Input name="password" icon={FiLock} type="password" placeholder="Senha" />

               <Button type="submit" loading={loading}>Entrar</Button>
            </Form>
         </Content>

         <Background />
      </Container>
   );
};

export default SignIn;

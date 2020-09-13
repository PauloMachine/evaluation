import styled from 'styled-components';
import { Form } from '@unform/web';

import Input from '../Input';
import Button from '../Button';

export const RButton = styled(Button)`
   background-color: #008000;
   border: none !important;
   margin-top: 0 !important;
`;

export const RCenter = styled.div`
   display: flex;
   align-items: center;
   justify-content: center;
   padding: 10px;
`;

export const RForm = styled(Form)`
   display: flex;
   align-items: center;
   justify-content: center;
   border: 1px solid #ccc;
   border-radius: 10px;
   padding-right: 1px;
   background-color: #232129 !important;
`;

export const RInput = styled(Input)``;

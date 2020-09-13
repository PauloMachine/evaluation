import styled from 'styled-components';
import { Col, Row, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

import { Form } from '@unform/web';

import Input from '../../components/Input';
import Button from '../../components/Button';

interface ButtonProps {
   background?: string;
}

export const RButton = styled(Button)<ButtonProps>`
   background-color: ${props => (props.background ? `${props.background}` : '#008000')};
   border: none !important;
   margin-top: 0 !important;
`;

export const RCenter = styled.div`
   display: flex;
   align-items: center;
   justify-content: space-between;
   padding: 10px;
`;

export const RForm = styled(Form)`
   display: flex;
   align-items: center;
   justify-content: center;
   border: 1px solid #ccc !important;
   border-radius: 10px;
   padding-right: 1px;
   background-color: #232129 !important;
   margin-left: 10px;
   margin-right: 10px;

   div {
      border: none !important;
   }
`;

export const RInput = styled(Input)`
   background: transparent !important;
   height: 100%;
   border: none !important;
`;

export const RContainer = styled.div``;

export const RCol = styled(Col)`
   align-items: center;
   justify-content: center;
   text-align: center;
   padding-right: 0px;
   padding-left: 0px;
`;

export const RRow = styled(Row)`
   padding: 5px !important;
   margin-left: 0px !important;
   margin-right: 0px !important;
`;

export const RRowHistoric = styled(Row)`
   background-color: ${props => props.backgroundcolor} !important;
   border: ${props => (props.border ? '1px solid #fff' : null)};
`;

export const RColHistoric = styled(Col)`
   align-items: center;
   justify-content: center;
   text-align: center;
   background-color: ${props => props.backgroundcolor} !important;
   padding-right: 0px;
   padding-left: 0px;
   border: ${props => (props.border ? '1px solid #555' : null)};
   border-right: ${props => (props.borderright ? '1px solid #555' : null)};
   border-left: ${props => (props.borderleft ? '1px solid #555' : null)};
`;

export const RText = styled.h2`
   font-weight: 800 !important;
   font-size: 25px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RTextInformation = styled.h2`
   font-weight: 800 !important;
   font-size: 10px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RCenterHistoric = styled.div`
   display: flex;
   align-items: center;
   justify-content: center;
`;

export const RModal = styled(Modal)`
   background: #2f2c36 !important;
   border: none !important;
   border-radius: 0px !important;

   div {
      border: none !important;
   }

   .close {
      color: #fff;
   }
`;

export const RModalHeader = styled(ModalHeader)`
   background: #2f2c36 !important;
   border: none !important;
   border-top-left-radius: 0px;
   border-top-right-radius: 0px;
`;

export const RModalBody = styled(ModalBody)`
   background: #2f2c36 !important;
   border: none !important;
`;

export const RModalFooter = styled(ModalFooter)`
   background: #2f2c36 !important;
   border: none !important;
   border-bottom-left-radius: 0px;
   border-bottom-right-radius: 0px;
`;

import styled from 'styled-components';

import { Table, Col, Row, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

import { Form } from '@unform/web';
import Input from '../../components/Input';
import Button from '../../components/Button';

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

   svg {
      visibility: hidden !important;
   }
`;

interface ButtonProps {
   background?: string;
}

export const RButton = styled(Button)<ButtonProps>`
   background-color: ${props => (props.background ? `${props.background}` : '#008000')};
   border: none !important;
   margin-top: 0 !important;
`;

export const RContainer = styled.div``;

export const RTable = styled(Table)`
   border: 1px solid #fff !important;

   td {
      max-width: 50px !important;
   }

   tr td {
      white-space: pre-wrap;
      word-wrap: break-word;
   }

   th:nth-child(odd) {
      padding: 5px !important;
      background-color: rgba(255, 0, 0, 0.5);
      width: 20px !important;
   }
   th:nth-child(even) {
      padding: 5px !important;
      background-color: rgba(0, 0, 0, 0.5);
      width: 20px !important;
   }
`;

export const Thead = styled.thead``;

export const Tr = styled.tr`
   color: #fff;
   border: 1px solid #fff !important;
`;

export const Th = styled.th`
   text-align: center;
   width: 100px;
   border: 1px solid #fff !important;
`;

export const Td = styled.td`
   text-align: center;
   color: #fff;
   border: 1px solid #222 !important;
   padding: 5px !important;
   width: 50px !important;
   height: 10px !important;
   font-weight: 500 !important;

   button {
      height: 33px !important;
      width: 70% !important;
   }
`;

export const Tbody = styled.tbody``;

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

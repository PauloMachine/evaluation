import styled from 'styled-components';
import { Col, Row } from 'reactstrap';

export const RRow = styled(Row)`
   background-color: ${props => props.backgroundcolor} !important;
   border: ${props => (props.border ? '1px solid #fff' : null)};
`;

export const RCol = styled(Col)`
   align-items: center;
   justify-content: center;
   text-align: center;
   background-color: ${props => props.backgroundcolor} !important;
   padding-right: 0px;
   padding-left: 0px;
   border: ${props => (props.border ? '1px solid #fff' : null)};
   border-right: ${props => (props.borderright ? '1px solid #fff' : null)};
   border-left: ${props => (props.borderleft ? '1px solid #fff' : null)};
`;

export const RText = styled.h2`
   font-weight: 800 !important;
   font-size: 25px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RTextInformation = styled.h2`
   font-weight: 800 !important;
   font-size: 14px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RCenter = styled.div`
   display: flex;
   align-items: center;
   justify-content: center;
`;

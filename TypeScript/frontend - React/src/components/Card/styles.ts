import styled from 'styled-components';
import { Card, CardHeader, CardBody, CardFooter } from 'reactstrap';

export const RCard = styled(Card)`
   background-color: rgba(41, 97, 120, 0.25) !important;
   box-shadow: 1px 1px 30px 5px rgba(0, 0, 0, 0.1);
   margin: 5px !important;
`;

export const RCardHeader = styled(CardHeader)`
   display: flex;
   align-items: center;
   justify-content: center;
`;

export const RCardBody = styled(CardBody)`
   img {
      width: 100px;
      height: auto;
   }
`;

export const RCardFooter = styled(CardFooter)``;

export const RCardH4 = styled.h4`
   font-weight: 600 !important;
   font-size: 20px;
   color: #fff;
`;

import styled from 'styled-components';

import { Button, Table } from 'reactstrap';

export const RTable = styled(Table)`
   border: 1px solid #fff !important;

   tr td {
      white-space: pre-wrap;
      word-wrap: break-word;
   }

   Thead tr th {
      padding: 0rem !important;
      height: 60px;

      button {
         font-weight: 600;
         font-size: 20px;
         background: transparent !important;
         color: #fff;
         width: 100%;
         height: 100%;
      }
   }

   th:nth-child(odd) {
      background-color: rgba(0, 0, 0, 0.5);
   }

   th:nth-child(even) {
      background-color: rgba(255, 0, 0, 0.5);
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
   font-weight: 800 !important;
   font-size: 30px;
   color: rgba(255, 255, 255, 0.7);
   border: 1px solid #fff !important;
`;

export const Tbody = styled.tbody``;

export const RButton = styled(Button)`
   background: #008000 !important;
   font-weight: 600;
   font-size: 15px;
   color: #fff;
   width: 100px;
   height: 60px;
   border-radius: 50px;
   margin-top: 10px;
   border: none;
`;

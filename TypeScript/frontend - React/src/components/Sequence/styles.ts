import styled from 'styled-components';

import { Table } from 'reactstrap';

export const RTable = styled(Table)`
   border: 1px solid #fff !important;

   tr td {
      white-space: pre-wrap;
      word-wrap: break-word;
   }

   th:nth-child(odd) {
      padding: 5px !important;
      background-color: rgba(0, 0, 0, 0.5);
   }
   th:nth-child(even) {
      padding: 5px !important;
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
   font-size: 20px;
   color: rgba(255, 255, 255, 0.7);
   border: 1px solid #fff !important;
`;

export const Tbody = styled.tbody``;

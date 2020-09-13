import styled from 'styled-components';
import { shade } from 'polished';

export const Container = styled.button`
   background: #111;
   height: 56px;
   border-radius: 10px;
   border: 0;
   padding: 0 16px;
   color: #fff;
   width: 100%;
   font-weight: bold;
   margin-top: 16px;

   transition: background-color 0.2s;
   &:hover {
      background: ${shade(0.2, '#111')};
   }

   img {
      width: 30px;
      margin-left: 10px;
      margin-right: 10px;
   }
`;

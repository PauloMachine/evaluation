import styled, { css } from 'styled-components';
import Tooltip from '../Tooltip';

interface ContainerProps {
   isFocused: boolean;
   isField: boolean;
   isErrored: boolean;
}

export const Container = styled.div<ContainerProps>`
   background: #232129;
   border-radius: 10px;
   padding: 16px;
   width: 100%;

   color: #666360;
   border: 2px solid #232129;

   display: flex;
   align-items: center;

   input {
      flex: 1;
      background: transparent;
      border: 0;
      color: #f4ede8;

      &::placeholder {
         color: #666360;
      }
   }

   /* Se tiver erro aplica cor */
   ${props =>
      props.isErrored &&
      css`
         border-color: #c53030;
      `}


   /* Se tiver com o foco aplica a cor */
   ${props =>
      props.isFocused &&
      css`
         color: #000;
         border: 2px solid #000;
      `}

   /* Se tiver valor deixa a cor */
   ${props =>
      props.isField &&
      css`
         color: #000;
      `}

   & + div {
      margin-top: 8px;
   }

   svg {
      margin-right: 16px;
   }
`;

export const TooltipError = styled(Tooltip)`
   height: 20px;
   margin-left: 16px;
   svg {
      margin: 0;
   }
`;

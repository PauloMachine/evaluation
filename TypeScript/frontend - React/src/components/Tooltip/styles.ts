import styled from 'styled-components';

interface ContainerProps {
   colorType: string;
}

export const Container = styled.div<ContainerProps>`
   position: relative;

   span {
      width: 160px;
      background: ${props => props.colorType};
      padding: 8px;
      border-radius: 4px;
      font-size: 14px;
      font-weight: bold;

      position: absolute;
      bottom: calc(100% + 12px);
      /* quando quiser centralizar */
      left: 50%;
      transform: translateX(-50%);

      color: #f4ede8;

      visibility: hidden;
      opacity: 0;
      transition: opacity 0.4s;

      &::before {
         content: '';
         top: 100%;
         position: absolute;
         border-style: solid;
         border-color: ${props => props.colorType} transparent;
         border-width: 6px 6px 0 6px;
         left: 50%;
         transform: translateX(-50%);
      }
   }

   &:hover span {
      opacity: 1;
      visibility: visible;
   }
`;

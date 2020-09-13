import React from 'react';

import { Container } from './styles';

interface TooltiProps {
   title: string;
   className?: string;
   colorType?: string;
}

const Tooltip: React.FC<TooltiProps> = ({ title, className, children, colorType = '#ff9000' }) => {
   return (
      <Container className={className} colorType={colorType}>
         {children}
         <span>{title}</span>
      </Container>
   );
};

export default Tooltip;

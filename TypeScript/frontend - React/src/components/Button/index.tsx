import React, { ButtonHTMLAttributes } from 'react';

import Roulette from '../../assets/roulette.gif';
import { Container } from './styles';

type ButtonProps = ButtonHTMLAttributes<HTMLButtonElement> & {
   loading?: boolean;
};

const Button: React.FC<ButtonProps> = ({ children, loading, ...rest }) => (
   <Container type="button" {...rest}>
      {loading ? <img src={Roulette} alt="roulette" /> : children}
   </Container>
);

export default Button;

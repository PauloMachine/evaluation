import React from 'react';
import { RCard, RCardBody, RCardFooter, RCardHeader, RCardH4 } from './styles';

import Roulette from '../../assets/roulette.gif';

interface CardProps {
   title?: string;
   children: object;
   className?: string;
   loading?: boolean;
}

const Card: React.FC<CardProps> = ({ title, children, className , loading }) => {
   return (
         <RCard className={className}>
            <RCardHeader>
               <RCardH4>{title}</RCardH4>
            </RCardHeader>
            <RCardBody>{loading ? <img src={Roulette} alt="roulette" /> : children}
            </RCardBody>
            <RCardFooter />
         </RCard>
   );
};

export default Card;

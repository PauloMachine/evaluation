import React from 'react';

import Card from '../Card';

import { RCenter, RText, RCol, RRow, RTextInformation } from './styles';

const Historic: React.FC = () => {
   return (
      <RCol xl="12">
         <Card title="Histórico">
            <RRow>
               <RCol backgroundcolor="rgba(0, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 10</RTextInformation>
                  <RCenter>
                     <RText>20</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 9</RTextInformation>
                  <RCenter>
                     <RText>11</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(0, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 8</RTextInformation>
                  <RCenter>
                     <RText>26</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 7</RTextInformation>
                  <RCenter>
                     <RText>3</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 6</RTextInformation>
                  <RCenter>
                     <RText>15</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(0, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 5</RTextInformation>
                  <RCenter>
                     <RText>24</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 4</RTextInformation>
                  <RCenter>
                     <RText>9</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(0, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 3</RTextInformation>
                  <RCenter>
                     <RText>30</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 2</RTextInformation>
                  <RCenter>
                     <RText>23</RText>
                  </RCenter>
               </RCol>
               <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border>
                  <RTextInformation>ROUND 1</RTextInformation>
                  <RCenter>
                     <RText>13</RText>
                  </RCenter>
               </RCol>
            </RRow>
         </Card>
      </RCol>
   );
};

export default Historic;

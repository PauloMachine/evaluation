import React from 'react';

import Card from '../Card';

import { RCenter, RFlexEnd, RFlexStart, RText, RCol, RRow, RTextInformation } from './styles';

const Board: React.FC = () => {
   const stone = Number(localStorage.getItem('@RouletteApp:stone_id'));
   return (
      <Card title="Round atual">
         <RRow>
            <RCol backgroundcolor="rgba(0, 128, 0, 1)" border bordertopleftradius />
            <RCol backgroundcolor={stone === 3 ? 'rgba(255, 255, 255, 0.1)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>3</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 6 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>6</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 9 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>9</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 12 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>12</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 15 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>15</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 18 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>18</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 21 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>21</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 24 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>24</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 27 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>27</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 30 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>30</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 33 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>33</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 36 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>36</RText>
               </RCenter>
            </RCol>
            <RCol border>
               <RCenter>
                  <RTextInformation>2-1</RTextInformation>
               </RCenter>
            </RCol>
         </RRow>
         <RRow>
            <RCol backgroundcolor={stone === 0 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 128, 0, 1)'} border>
               <RCenter>
                  <RText>0</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 2 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>2</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 5 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>5</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 8 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>8</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 11 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>11</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 14 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>14</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 17 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>17</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 20 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>20</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 23 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>23</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 26 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>26</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 29 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>29</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 32 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>32</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 35 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>35</RText>
               </RCenter>
            </RCol>
            <RCol border>
               <RCenter>
                  <RTextInformation>2-1</RTextInformation>
               </RCenter>
            </RCol>
         </RRow>
         <RRow>
            <RCol backgroundcolor="rgba(0, 128, 0, 1)" border borderbottomleftradius />
            <RCol backgroundcolor={stone === 1 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>1</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 4 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>4</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 7 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>7</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 10 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>10</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 13 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>13</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 16 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>16</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 19 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>19</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 22 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>22</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 25 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>25</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 28 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>28</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 31 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(0, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>31</RText>
               </RCenter>
            </RCol>
            <RCol backgroundcolor={stone === 34 ? 'rgba(255, 255, 255, 0.3)' : 'rgba(255, 0, 0, 0.5)'} border>
               <RCenter>
                  <RText>34</RText>
               </RCenter>
            </RCol>
            <RCol border>
               <RCenter>
                  <RTextInformation>2-1</RTextInformation>
               </RCenter>
            </RCol>
         </RRow>
         <RRow>
            <RCol />
            <RCol borderleft borderbottom />
            <RCol>
               <RFlexEnd>
                  <RTextInformation>1a</RTextInformation>
               </RFlexEnd>
            </RCol>
            <RCol>
               <RFlexStart>
                  <RTextInformation>12</RTextInformation>
               </RFlexStart>
            </RCol>
            <RCol borderright borderbottom />
            <RCol borderleft borderbottom />
            <RCol>
               <RFlexEnd>
                  <RTextInformation>2a</RTextInformation>
               </RFlexEnd>
            </RCol>
            <RCol>
               <RFlexStart>
                  <RTextInformation>12</RTextInformation>
               </RFlexStart>
            </RCol>
            <RCol borderright borderbottom />
            <RCol borderleft borderbottom />
            <RCol>
               <RFlexEnd>
                  <RTextInformation>3a</RTextInformation>
               </RFlexEnd>
            </RCol>
            <RCol>
               <RFlexStart>
                  <RTextInformation>12</RTextInformation>
               </RFlexStart>
            </RCol>
            <RCol borderright borderbottom />
            <RCol />
         </RRow>
         <RRow>
            <RCol />
            <RCol border>
               <RCenter>
                  <RTextInformation>1 a 18</RTextInformation>
               </RCenter>
            </RCol>
            <RCol border>
               <RCenter>
                  <RTextInformation>Par</RTextInformation>
               </RCenter>
            </RCol>
            <RCol />
            <RCol backgroundcolor="rgba(255, 0, 0, 0.5)" border />
            <RCol backgroundcolor="rgba(0, 0, 0, 0.5)" border />
            <RCol />
            <RCol border>
               <RCenter>
                  <RTextInformation>Impar</RTextInformation>
               </RCenter>
            </RCol>
            <RCol border>
               <RCenter>
                  <RTextInformation>19 a 36</RTextInformation>
               </RCenter>
            </RCol>
            <RCol />
         </RRow>
      </Card>
   );
};

export default Board;

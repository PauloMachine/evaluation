import styled from 'styled-components';
import { Col, Row } from 'reactstrap';

export const RRow = styled(Row)`
   background-color: ${props => props.backgroundcolor} !important;
   border: ${props => (props.border ? '1px solid #fff' : null)};
   border-bottom-left-radius: ${props => (props.borderbottomleftradius ? '50px' : null)};
   border-bottom-right-radius: ${props => (props.borderbottomrightradius ? '50px' : null)};
`;

export const RCol = styled(Col)`
   align-items: center;
   justify-content: center;
   text-align: center;
   background-color: ${props => props.backgroundcolor} !important;
   padding-right: 0px;
   padding-left: 0px;
   border: ${props => (props.border ? '1px solid #fff' : null)};
   border-right: ${props => (props.borderright ? '1px solid #fff' : null)};
   border-left: ${props => (props.borderleft ? '1px solid #fff' : null)};
   border-bottom: ${props => (props.borderbottom ? '1px solid #fff' : null)};
   border-bottom-left-radius: ${props => (props.borderbottomleftradius ? '30px' : null)};
   border-bottom-right-radius: ${props => (props.borderbottomrightradius ? '30px' : null)};
   border-top-left-radius: ${props => (props.bordertopleftradius ? '30px' : null)};
   border-top-right-radius: ${props => (props.bordertoprightradius ? '30px' : null)};
`;

export const RText = styled.h2`
   font-weight: 800 !important;
   font-size: 18px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RTextInformation = styled.h2`
   font-weight: 800 !important;
   font-size: 10px;
   color: rgba(255, 255, 255, 0.9);
`;

export const RCenter = styled.div`
   display: flex;
   align-items: center;
   justify-content: center;
   padding: 10px;
`;

export const RFlexEnd = styled.div`
   display: flex;
   align-items: center;
   justify-content: flex-end;
   padding: 10px;
`;

export const RFlexStart = styled.div`
   display: flex;
   align-items: center;
   justify-content: flex-start;
   padding: 10px;
`;

import styled from 'styled-components';
import { Form } from '@unform/web';
import {
   Button,
   Collapse,
   Navbar,
   NavbarToggler,
   NavbarBrand,
   Nav,
   UncontrolledDropdown,
   DropdownToggle,
   DropdownMenu,
   DropdownItem,
   NavbarText,
} from 'reactstrap';

export const RNavbar = styled(Navbar)`
   height: 60px !important;
   background-color: rgba(0, 0, 0, 0.3) !important;
   box-shadow: inset 0 -0.1rem 0 rgba(0, 0, 0, 0.25);
   padding: 10px 50px 10px 50px;

   a {
      color: #fff !important;
      font-size: 20px;
   }
`;

export const RButton = styled(Button)`
   background-color: #ff9000;
   border: none !important;
`;

export const RForm = styled(Form)`
   display: flex;
   align-items: center;
   justify-content: center;
   width: 245px;
   height: 42px;
   border-radius: 50px;
   border: 1px solid #ccc;
   background-color: rgba(255, 255, 255, 0.2);
   padding: 22px;

   input {
      background-color: transparent;
      border: none;
      width: 140px;
      height: 42px;
      color: #ff9000;
      margin-left: 10px;
   }

   button {
      border-radius: 50px;
      height: 42px;
   }
`;

export const RCollapse = styled(Collapse)`
   margin-top: 5px;
   margin-bottom: 5px;
`;

export const RDropdownItem = styled(DropdownItem)`
   span {
      font-size: 15px;
      font-weight: 400;
      color: #212529;
      white-space: nowrap;
   }
`;

export const RSpan = styled.span``;
export const RInput = styled.input``;
export const RNavbarToggler = styled(NavbarToggler)``;
export const RNavbarBrand = styled(NavbarBrand)``;
export const RNav = styled(Nav)``;
export const RUncontrolledDropdown = styled(UncontrolledDropdown)``;
export const RDropdownToggle = styled(DropdownToggle)``;
export const RDropdownMenu = styled(DropdownMenu)``;
export const RNavbarText = styled(NavbarText)``;

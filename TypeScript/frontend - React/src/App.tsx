import React from 'react';
import { ToastContainer } from 'react-toastify';
import { BrowserRouter } from 'react-router-dom';

import GlobalStyle from './styles/global';
import './styles/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';

import Routes from './routes';

import AppProvider from './hooks';

const App: React.FC = () => (
   <BrowserRouter>
      <AppProvider>
         <ToastContainer />
         <Routes />
      </AppProvider>
      <GlobalStyle />
   </BrowserRouter>
);

export default App;

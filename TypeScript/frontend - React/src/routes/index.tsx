import React from 'react';
import { Switch } from 'react-router-dom';

import Route from './Route';

import SignIn from '../pages/SignIn';
import Dashboard from '../pages/Dashboard';
import Configuracoes from '../pages/Configuracoes';
import SequenceOnClick from '../pages/SequenceOnClick';

const Routes: React.FC = () => (
   <Switch>
      <Route path="/" exact component={SignIn} />
      <Route path="/dashboard" exact component={Dashboard} isPrivate />
      <Route path="/sequenceOnClick" exact component={SequenceOnClick} isPrivate />
      <Route path="/configuracoes" exact component={Configuracoes} isPrivate />
      <Route path="*" component={Dashboard} isPrivate />
   </Switch>
);

export default Routes;

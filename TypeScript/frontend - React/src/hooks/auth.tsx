import React, { createContext, useCallback, useState, useContext } from 'react';
import api from '../services/api';

interface AuthState {
   token: string;
   user: object;
}

interface SignInCredentials {
   username: string;
   password: string;
}

interface AuthContextData {
   user: object;
   signOut(): void;
   signIn(credentials: SignInCredentials): Promise<void>;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

const AuthProvider: React.FC = ({ children }) => {
   const [data, setData] = useState<AuthState>(() => {
      const token = localStorage.getItem('@RouletteApp:token');
      const user = localStorage.getItem('@RouletteApp:user');

      if (token && user) {
         return { token, user: JSON.parse(user) };
      }

      return {} as AuthState;
   });

   const signIn = useCallback(async ({ username, password }) => {
      const response = await api.post('sessions', {
         username,
         password,
      });

      const { token, user } = response.data;

      localStorage.setItem('@RouletteApp:token', token);
      localStorage.setItem('@RouletteApp:user', JSON.stringify(user));

      setData({ token, user });
   }, []);

   const signOut = useCallback(() => {
      localStorage.removeItem('@RouletteApp:token');
      localStorage.removeItem('@RouletteApp:user');
      setData({} as AuthState);
   }, []);

   return <AuthContext.Provider value={{ user: data.user, signIn, signOut }}>{children}</AuthContext.Provider>;
};

function useAuth(): AuthContextData {
   const context = useContext(AuthContext);

   if (!context) {
      throw new Error('useAuth must be used within an AuthProvider');
   }

   return context;
}

export { AuthContext, AuthProvider, useAuth };

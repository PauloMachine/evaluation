/* eslint-disable @typescript-eslint/no-explicit-any, no-param-reassign */
import axios from 'axios';

const api = axios.create({
   baseURL: '',
});

api.interceptors.request.use(
   async (config: any) => {
      const token = localStorage.getItem('@RouletteApp:token');

      if (token) {
         config.headers.Authorization = `Bearer ${token}`;
      }

      return config;
   },
   async (error: any) => {
      if (error.response?.status >= 400) {
         // Limpa o storage
         await localStorage.removeItem('@RouletteApp:token');
         await localStorage.removeItem('@RouletteApp:user');
      }
      return Promise.reject(error);
   },
);

api.interceptors.response.use(
   (response: any) => response,
   async (error: any) => {
      if (error.response?.status >= 400) {
         // Limpa o storage
         await localStorage.removeItem('@RouletteApp:token');
         await localStorage.removeItem('@RouletteApp:user');
      }

      return Promise.reject(error);
   },
);

export default api;

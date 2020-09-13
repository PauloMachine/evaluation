import React, { InputHTMLAttributes, useEffect, useRef, useState, useCallback } from 'react';
import { IconBaseProps } from 'react-icons';
import { FiAlertCircle } from 'react-icons/fi';
import { useField } from '@unform/core';

import { Container, TooltipError } from './styles';

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
   name: string;
   icon?: React.ComponentType<IconBaseProps>;
}

const Input: React.FC<InputProps> = ({ name, icon: Icon, ...rest }) => {
   const inputRef = useRef<HTMLInputElement>(null);

   const [isFocused, setIsFocused] = useState(false);
   const [isField, setIsField] = useState(false);

   const { fieldName, defaultValue, error, registerField } = useField(name);

   const handleInputBlur = useCallback(() => {
      setIsFocused(false);

      // quando sair do campo ja tiver algum valor
      if (inputRef.current?.value) {
         setIsField(true);
      } else {
         setIsField(false);
      }
   }, []);

   const handleInputFocus = useCallback(() => {
      setIsFocused(true);
   }, []);

   useEffect(() => {
      registerField({
         ref: inputRef.current,
         name: fieldName,
         path: 'value', // da onde será pega o value do input
         clearValue(ref: any) {
            ref.value = '';
            ref.clear();
         },
      });
   }, [fieldName, registerField]);

   return (
      <Container isErrored={!!error} isField={isField} isFocused={isFocused}>
         {Icon && <Icon size={20} color="#ccc" />}
         <input
            onFocus={handleInputFocus}
            onBlur={handleInputBlur}
            defaultValue={defaultValue}
            ref={inputRef}
            autoComplete="off"
            {...rest}
         />

         {error && (
            <TooltipError title={error} colorType="#c53030">
               <FiAlertCircle color="#c53030" size={20} />
            </TooltipError>
         )}
      </Container>
   );
};

export default Input;

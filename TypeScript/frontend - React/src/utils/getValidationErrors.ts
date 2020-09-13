import { ValidationError } from 'yup';

interface ErrorsDTO {
   [key: string]: string;
}

export default function getValidationErrors(err: ValidationError): ErrorsDTO {
   const validationErrors: ErrorsDTO = {};

   err.inner.forEach(error => {
      validationErrors[error.path] = error.message;
   });

   return validationErrors;
}

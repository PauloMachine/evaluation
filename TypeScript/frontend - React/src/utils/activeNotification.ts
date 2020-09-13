import { toast } from 'react-toastify';

function activeNotification(description: string) {
   const context = new AudioContext();
   const oscillator = context.createOscillator();
   const contextGain = context.createGain();

   oscillator.connect(contextGain);
   contextGain.connect(context.destination);
   oscillator.start(0);
   toast.success(`A sequência ${description} atingiu o limite configurado!`, {
      autoClose: 5000,
   });
   contextGain.gain.exponentialRampToValueAtTime(0.00001, context.currentTime + 1);
}

export default activeNotification;

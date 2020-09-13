export const getGamerId = () => localStorage.getItem('@RouletteApp:gamer_id');
export const setGamerId = (gamer_id: number) => {
   localStorage.setItem('@RouletteApp:gamer_id', String(gamer_id));
};

export const getStoneId = () => localStorage.getItem('@RouletteApp:stone_id');
export const setStoneId = (stone_id: number) => {
   localStorage.setItem('@RouletteApp:stone_id', String(stone_id));
};

export const getRoundId = () => localStorage.getItem('@RouletteApp:round_id');
export const setRoundId = (round_id: number) => {
   localStorage.setItem('@RouletteApp:round_id', String(round_id));
};

export const getRoundHistoric = () => localStorage.getItem('@RouletteApp:roundHistoric');
export const setRoundHistoric = () => {
   let roundAtual = Number(getRoundHistoric());
   localStorage.setItem('@RouletteApp:roundHistoric', String((roundAtual += 1)));
};

export const getSituationId = () => localStorage.getItem('@RouletteApp:situation_id');
export const setSituationId = (situation_id: number) => {
   localStorage.setItem('@RouletteApp:situation_id', String(situation_id));
};

export const removeStorage = () => {
   localStorage.removeItem('@RouletteApp:gamer_id');
   localStorage.removeItem('@RouletteApp:stone_id');
   localStorage.removeItem('@RouletteApp:round_id');
   localStorage.removeItem('@RouletteApp:sequence');
   localStorage.removeItem('@RouletteApp:historic');
   localStorage.removeItem('@RouletteApp:situation_id');
   localStorage.removeItem('@RouletteApp:roundHistoric');
};

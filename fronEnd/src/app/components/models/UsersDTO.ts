import {PersonaDTO} from './PersonaDTO'; 

export  class UsersDTO {
    constructor(
       public nombreUsuario: string,
       public email: string,
       public password : string,
       public personaDTO: PersonaDTO 
    ){ 
        
    }
   }
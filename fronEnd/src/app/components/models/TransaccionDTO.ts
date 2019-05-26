import {UsersDTO} from './UsersDTO'; 
export class TransaccionDTO {
        constructor(
            public fechaIngreso:string,
            public cantidadIngreso: number,
            public estadoPago:number,
            public mes:number,
            public dia: number,
            public anio : number,
            public usersDTO:UsersDTO
        ){
           


        }
}


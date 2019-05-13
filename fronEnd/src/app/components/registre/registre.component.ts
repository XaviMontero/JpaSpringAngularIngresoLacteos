import { Component,OnInit } from '@angular/core';
import {ActivatedRoute,Params, Router} from '@angular/router';
import {UsersDTO} from '../models/UsersDTO'
import { PersonaDTO } from '../models/PersonaDTO';
@Component({
    selector: 'registre',
    templateUrl:'./registre.component.html',
    styleUrls: ['./registre.component.sass']

})
export class RegistreComponent implements OnInit{
    public title:string; 
    public usersDTO:UsersDTO; 


    constructor(
        private _router:Router,
        private _activatedRoute:ActivatedRoute
    ){
        this.title='Hola Registre'
        this.usersDTO = new  UsersDTO(
            "",
            "",
            "",
            new PersonaDTO(
                "",
                "",
                "",
                "",
                "",
                ""
                )
        );
    }
    ngOnInit(){
        console.log("Cargado componentes")
    }
}
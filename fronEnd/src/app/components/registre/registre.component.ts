import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersDTO } from '../models/UsersDTO';
import { PersonaDTO } from '../models/PersonaDTO';
import { UsersDTOservices } from '../services/usersDTO.service';
import {CatalinaResponseDTO}from '../models/CatalinaResponseDTO';
@Component({
    selector: 'registre',
    templateUrl: './registre.component.html',
    styleUrls: ['./registre.component.sass'],
    providers: [UsersDTOservices]
})
export class RegistreComponent implements OnInit {
    public title: string;
    public usersDTO: UsersDTO;
    public personaDTO: PersonaDTO;
    public catalinaRespo : CatalinaResponseDTO;
    constructor(private _router: Router, private _activatedRoute: ActivatedRoute, private _usersDTOservices: UsersDTOservices) {
        this.title = 'Hola Registre';
        this.personaDTO = new PersonaDTO("", "", "", "", "", "");
        this.usersDTO = new UsersDTO("", "", "", this.personaDTO);
    }
    ngOnInit() {
        console.log("Cargado componentes");
    }
    onSubmit() {
        this._usersDTOservices.registre(this.usersDTO).subscribe(

            response=>{
                this.catalinaRespo = response; 
            console.log("Su ingreso "+ this.catalinaRespo.success);
            },
            error=>{
             console.log(error);
            }
        );
    }
}

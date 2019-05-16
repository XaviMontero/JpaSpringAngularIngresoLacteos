import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersDTO } from '../models/UsersDTO';
import { PersonaDTO } from '../models/PersonaDTO';
import { UsersDTOservices } from '../services/usersDTO.service';
import {CatalinaResponseDTO}from '../models/CatalinaResponseDTO';
import { ReportesPorUsuarioDTO } from '../models/ReportesPorUsuarioDTO';
import {ReportesPorUsuarioDTOservices}from '../services/ReportesPorUsuarioDTO.service';


@Component({
    selector: 'login',
    templateUrl:'./login.component.html',
    styleUrls: ['./login.component.sass'],
    providers: [UsersDTOservices,ReportesPorUsuarioDTOservices]


})
export class LoginComponent implements OnInit{
    public title: string;
    public usersDTO: UsersDTO;
    public personaDTO: PersonaDTO;
    public catalinaRespo : CatalinaResponseDTO;
    public status: string; 
    public listReport: Array<ReportesPorUsuarioDTO>
    constructor(private _router: Router, private _activatedRoute: ActivatedRoute, private _usersDTOservices: UsersDTOservices,
        private _reportesDTOservices: ReportesPorUsuarioDTOservices) {
        this.title = 'Hola Registre';
        this.personaDTO = new PersonaDTO("", "", "", "", "", "");
        this.usersDTO = new UsersDTO("", "", "", this.personaDTO);
    }
    
    ngOnInit(){
        console.log("Cargado componentes login");
        
    }
    onSubmit(from) {
        this._usersDTOservices.login(this.usersDTO).subscribe(
            response=>{
                this.catalinaRespo = response; 
                if (this.catalinaRespo.success){
                    this.status="true"; 
                    from.reset();
                    localStorage.setItem('estado',this.status);
                    this._router.navigate(['/']);
                }else {
                    this.status="false";
                    localStorage.setItem('estado',this.status);
                    from.reset();
                }
            console.log("Su ingreso "+ this.catalinaRespo.success);
            },
            error=>{
                console.log("Su ingreso "+ this.catalinaRespo.success);
                localStorage.setItem('estado',this.status);

                
             this.status="false";
             from.reset();
            }
        );
       
    
    }
     


}


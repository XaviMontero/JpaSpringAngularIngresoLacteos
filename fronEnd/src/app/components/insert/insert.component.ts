import { Component, OnInit } from '@angular/core';
import { UsersDTO } from '../models/UsersDTO';
import { PersonaDTO } from '../models/PersonaDTO';
import { UsersDTOservices } from '../services/usersDTO.service';
import { ActivatedRoute, Router } from '@angular/router';
import {CatalinaResponseDTO}from '../models/CatalinaResponseDTO';
import {TransaccionDTO}from '../models/TransaccionDTO';
import {ReportesPorUsuarioDTOservices}from '../services/ReportesPorUsuarioDTO.service';
import { Response } from 'selenium-webdriver/http';

@Component({
    selector: 'insert',
    templateUrl:'./insert.component.html',
    styleUrls: ['./insert.component.sass'] ,
    providers:[ReportesPorUsuarioDTOservices]


})
export class InsertComponent implements OnInit{
     public title: string;
     public status: string; 
     public cedula: string; 
     public nombres:string; 
     public usersDTO: UsersDTO;
     public personaDTO: PersonaDTO;
     public catalinaRespo : CatalinaResponseDTO;
     public direccion:string; 
     public telefono : string; 
     public estado : string; 
     public cantidad : number; 
     public trasaccionDTO : TransaccionDTO; 

    constructor(private _router: Router, private _activatedRoute: ActivatedRoute, private _usersDTOservices: UsersDTOservices,
                private _reportesDTOservices: ReportesPorUsuarioDTOservices ) {
        this.title = 'Hola Registre';
        this.personaDTO = new PersonaDTO("", "", "", "", "", "");
        this.usersDTO = new UsersDTO("", "", "", this.personaDTO);
        this.trasaccionDTO = new TransaccionDTO("2019-01-15",0,0,0,0,0,this.usersDTO);
     
    }
    
    ngOnInit(){
        console.log("Cargado componentes Insert");
        this.estado = localStorage.getItem('estado');
        if (this.estado=='true'){
            console.log('los componentes estan cargados'); 
        }else if (this.estado=='false'){
                this._router.navigate(['/login']);
        }
    }
    onKeydown(event) {
        if (event.key === "Tab") {
        console.log(this.cedula)
        this._usersDTOservices.getUserCedula(this.cedula).subscribe(
            response =>{
                this.usersDTO=response; 
                if(this.usersDTO!=null){
                    this.status='true'; 
                    this.nombres = this.usersDTO.personaDTO.nombrePersona+" "+ this.usersDTO.personaDTO.apellidosPersona;
                    this.direccion = this.usersDTO.personaDTO.direccion; 
                    this.telefono = this.usersDTO.personaDTO.telefonoPersona; 
                     
                }else {
                    this.status='false';
                }
                console.log(this.usersDTO); 
            },error=>{
                    console.log(error);
                    this.nombres =''; 
            }
        );
        }
      }
      onSubmit(transFrom){
          if (this.usersDTO!=null){
              if(this.cantidad!=null){
                this.trasaccionDTO.usersDTO=this.usersDTO; 
                this.trasaccionDTO.cantidadIngreso=this.cantidad; 
                console.log(this.trasaccionDTO); 
                this._reportesDTOservices.saveorUpdate(this.trasaccionDTO).subscribe(
                    response=>{
                        this.estado="true"; 
                        console.log(response); 
                        transFrom.reset(); 
                    },error=>{
                        this.estado="false"; 
                    }
                );
              }else{
                this.estado="false"; 
                console.log(this.estado);
              }

          }else{
                this.estado="false"; 
                console.log(this.estado);



          }
      }
}
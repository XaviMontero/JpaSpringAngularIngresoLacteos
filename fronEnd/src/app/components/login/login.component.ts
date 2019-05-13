import { Component,OnInit } from '@angular/core';

@Component({
    selector: 'login',
    templateUrl:'./login.component.html',
    styleUrls: ['./login.component.sass']


})
export class LoginComponent implements OnInit{
    public title:string; 

    constructor(){
        this.title='Hola login';
    }
    ngOnInit(){
        console.log("Cargado componentes");
    }
}
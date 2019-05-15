import { Component, OnInit } from '@angular/core';
 


@Component({
    selector: 'insert',
    templateUrl:'./insert.component.html',
    styleUrls: ['./insert.component.sass'] 


})
export class InsertComponent implements OnInit{
    public title: string;
 
    public status: string; 
    constructor( ) {
        this.title = 'Hola Registre';
     
    }
    
    ngOnInit(){
        console.log("Cargado componentes login");
    }
}
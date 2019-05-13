import { Component,OnInit } from '@angular/core';

@Component({
    selector: 'registre',
    templateUrl:'./registre.component.html'

})
export class RegistreComponent implements OnInit{
    public title:string; 

    constructor(){
        this.title='Hola Registre'
    }
    ngOnInit(){
        console.log("Cargado componentes")
    }
}
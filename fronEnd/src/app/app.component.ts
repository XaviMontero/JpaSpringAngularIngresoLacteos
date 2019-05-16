import { Component , OnInit,DoCheck } from '@angular/core';
import { UsersDTOservices } from './components/services/usersDTO.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass'],
  providers:[UsersDTOservices]
})
export class AppComponent implements OnInit,DoCheck  {
  title = 'fronEnd';
  public estado;
  constructor(
    private _userDTOservice:UsersDTOservices
  ){

  }
  ngOnInit(){
    console.log("Cargado componentes app");
    this.estado=this._userDTOservice.getStatus(); 
    console.log(this.estado);

  }
  ngDoCheck(){
    this.estado=this._userDTOservice.getStatus(); 

  }

}

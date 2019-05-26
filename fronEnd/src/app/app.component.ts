import { Component , OnInit,DoCheck } from '@angular/core';
import { UsersDTOservices } from './components/services/usersDTO.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass'],
  providers:[UsersDTOservices]
})
export class AppComponent implements OnInit,DoCheck  {
  title = 'fronEnd';
  public estado;
  public status: string; 
  constructor(
    private _userDTOservice:UsersDTOservices,
    private _router: Router, 
    private _activatedRoute: ActivatedRoute
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
  salir(){
    this.status='false'; 
    this._router.navigate(['/login']);
    localStorage.setItem('estado',this.status);


  }

}

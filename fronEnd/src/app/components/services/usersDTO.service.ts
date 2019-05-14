import {Injectable} from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {UsersDTO } from '../models/UsersDTO';
import {GLOBAL} from './global'; 

  @Injectable()
 export class UsersDTOservices{
     public url:string; 
     constructor (public _http:HttpClient){
         this.url = GLOBAL.url; 

     }
     registre(usersDTO:UsersDTO) : Observable<any> {
         let params = JSON.stringify(usersDTO); 
         console.log(params);
         let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8'); 
         return this._http.post(this.url+'create-user',params,{headers:headers});


          
     }

 }
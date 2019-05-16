import {Injectable} from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {UsersDTO } from '../models/UsersDTO';
import {GLOBAL} from './global'; 
@Injectable()
export class ReportesPorUsuarioDTOservices{
    public url:string; 
    constructor (public _http:HttpClient){
        this.url = GLOBAL.urlTrans; 

    }

    reporteUsuario(mesConsulta: number) : Observable<any> {
        let params = JSON.stringify(mesConsulta); 
        console.log(params);
       
        return this._http.get(this.url+mesConsulta+'/total-objeto');
     } 
}
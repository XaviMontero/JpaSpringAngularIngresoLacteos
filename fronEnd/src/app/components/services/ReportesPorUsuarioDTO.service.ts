import {Injectable} from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {UsersDTO } from '../models/UsersDTO';
import {TransaccionDTO } from '../models/TransaccionDTO';
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
     saveorUpdate(trasaccion: TransaccionDTO): Observable<any> {
        let params = JSON.stringify(trasaccion); 
        console.log(params);
        let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8'); 
        return this._http.post(this.url+'create-trans',params,{headers:headers});

     }
     reporteZonas(mesConsulta: number) : Observable<any> {
        let params = JSON.stringify(mesConsulta); 
        console.log(params);
        return this._http.get(this.url+mesConsulta+'/reporte-zona');
     }
}
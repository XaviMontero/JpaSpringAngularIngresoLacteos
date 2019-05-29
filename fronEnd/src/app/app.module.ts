import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule  } from './app.routing';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms'; 
import {HttpClientModule} from '@angular/common/http'
import { ChartsModule } from 'ng2-charts';
//component 
import {RegistreComponent} from './components/registre/registre.component';
import {LoginComponent} from './components/login/login.component'; 
import {ReportComponent} from './components/report/report.component'; 
import {InsertComponent} from './components/insert/insert.component'; 
import {PagosComponent} from './components/pagos/pagos.component'; 

@NgModule({
  declarations: [
    AppComponent,
    RegistreComponent,
    LoginComponent,
    ReportComponent,
    InsertComponent,
    PagosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    NgbModule.forRoot()
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

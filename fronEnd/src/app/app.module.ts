import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule  } from './app.routing';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms'; 
import {HttpClientModule} from '@angular/common/http'
//component 
import {RegistreComponent} from './components/registre/registre.component';
import {LoginComponent} from './components/login/login.component'; 


@NgModule({
  declarations: [
    AppComponent,
    RegistreComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
    NgbModule.forRoot()
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

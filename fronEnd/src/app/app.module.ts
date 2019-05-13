import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { routing,appRoutingProviders } from './app.routing';
import { AppComponent } from './app.component';

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
    routing,
    
    NgbModule.forRoot()
  ],
  providers: [
    appRoutingProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

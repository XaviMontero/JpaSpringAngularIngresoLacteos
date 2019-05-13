import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistreComponent} from './components/registre/registre.component';
import {LoginComponent} from './components/login/login.component'; 
const routes: Routes = [
    {path:'', component:LoginComponent},
    {path:'login',component:LoginComponent},
    {path:'registre',component:RegistreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistreComponent} from './components/registre/registre.component';
import {LoginComponent} from './components/login/login.component'; 
import {ReportComponent} from './components/report/report.component'; 
const routes: Routes = [
    {path:'', component:ReportComponent},
    {path:'login',component:LoginComponent},
    {path:'registre',component:RegistreComponent},
    {path:'report',component:ReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
import {ModuleWithProviders} from '@angular/core'; 
import {Routes,RouterModule} from '@angular/router'; 

 

//component 
import {RegistreComponent} from './components/registre/registre.component';
import {LoginComponent} from './components/login/login.component'; 
 
const appRoutes: Routes=[
    {path:'', component:LoginComponent},
    {path:'login',component:LoginComponent},
    {path:'registre',component:RegistreComponent}
];
export const appRoutingProviders : any[] =[]; 
export const routing:ModuleWithProviders=RouterModule.forRoot(appRoutes); 

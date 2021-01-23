import {Routes , RouterModule} from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AppURL } from './app.url';
import { RegisterComponent } from './components/register/register.component';
import { DashboardComponent } from './authentication/components/dashboard/dashboard.component';

const RouteList: Routes = [
    {path : '' , redirectTo: AppURL.Login , pathMatch: 'full'},
    {path : AppURL.Login, component: LoginComponent},
    {path : AppURL.Register , component: RegisterComponent},
    {path : AppURL.Authen , loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule)},
    {path: '**', component: DashboardComponent}
  ];

export const AppRouting = RouterModule.forRoot(RouteList);


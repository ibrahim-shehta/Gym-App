import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppURL } from '../app.url';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';


const routes: Routes = [
  {path : '' , redirectTo: AppURL.Login , pathMatch: 'full'},
  {path: AppURL.Login, component: LoginComponent},
  {path: AppURL.Register, component: RegisterComponent},
  {path: AppURL.ChangePassword, component: ChangePasswordComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UnAuthUserRoutingModule { }

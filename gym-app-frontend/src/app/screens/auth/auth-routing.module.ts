import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutingUrls } from 'src/app/core/constants/RoutingUrls';
import { AuthLayoutComponent } from './pages/auth-layout/auth-layout.component';
import { LoginComponent } from './pages/login/login.component';


const routes: Routes = [
  {
  path: '',
  redirectTo: RoutingUrls.LOGIN,
  pathMatch: 'full' ,
  },
  {
    path: '',
    component: AuthLayoutComponent,
    children: [
      {path: RoutingUrls.LOGIN, component: LoginComponent}
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }

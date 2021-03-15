import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnAuthUserRoutingModule } from './un-auth-user-routing.module';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { SharedsModule } from '../shareds/shareds.module';
import { UnAuthService } from './services/un-auth.service';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    ChangePasswordComponent
  ],
  imports: [
    CommonModule,
    UnAuthUserRoutingModule,
    SharedsModule
  ],
  providers: [
    UnAuthService
  ]
})
export class UnAuthUserModule { }

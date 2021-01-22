import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LoginComponent } from './pages/login/login.component';
import { AuthLayoutComponent } from './pages/auth-layout/auth-layout.component';
import { CoreModule } from 'src/app/core/core.module';


@NgModule({
  declarations: [LoginComponent, AuthLayoutComponent],
  imports: [
    CoreModule,
    AuthRoutingModule
  ]
})
export class AuthModule { }

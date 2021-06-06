import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedAuthenticationModule } from 'src/app/authentication/shared-authentication/shared-authentication.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedAuthenticationModule
  ],
  exports: [
    SharedAuthenticationModule
  ]
})
export class SharedExercisesModule { }

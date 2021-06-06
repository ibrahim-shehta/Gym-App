import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedsModule } from 'src/app/shareds/shareds.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedsModule
  ],
  exports: [
    SharedsModule
  ]
})
export class SharedAuthenticationModule { }

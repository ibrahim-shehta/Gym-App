import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedsModule } from '../../../../shareds/shareds.module';



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
export class SharedUserManagementModule { }

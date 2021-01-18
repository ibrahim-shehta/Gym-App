import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ScreensRoutingModule } from './screens-routing.module';
import { ScreensComponent } from './screens.component';


@NgModule({
  declarations: [ScreensComponent],
  imports: [
    CommonModule,
    ScreensRoutingModule
  ]
})
export class ScreensModule { }

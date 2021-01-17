import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ScreensRoutingModule } from './screens-routing.module';
import { ScreensComponent } from './screens.component';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';


@NgModule({
  declarations: [ScreensComponent, DashboardComponent],
  imports: [
    CommonModule,
    ScreensRoutingModule
  ]
})
export class ScreensModule { }

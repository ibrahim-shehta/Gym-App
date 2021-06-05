import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubscriptionsModuleRoutingModule } from './subscriptions-module-routing.module';
import { SharedsModule } from 'src/app/shareds/shareds.module';
import { PlansService } from './pages/plans/services/plans.service';
import { SubscriptionsService } from 'src/app/authentication/modules/subscriptions-module/pages/subscriptions/subscriptions/services/subscriptions.service';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SubscriptionsModuleRoutingModule,
    SharedsModule
  ],
  providers: [
    PlansService,
    SubscriptionsService
  ]
})
export class SubscriptionsModuleModule { }

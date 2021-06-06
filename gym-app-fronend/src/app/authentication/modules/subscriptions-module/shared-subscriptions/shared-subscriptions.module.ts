import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlansDetailsComponent } from './components/plans-details/plans-details.component';
import { SubscriptionsDetailsComponent } from './components/subscriptions-details/subscriptions-details.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { SelectPlanComponent } from './components/select-plan/select-plan.component';
import { SharedAuthenticationModule } from 'src/app/authentication/shared-authentication/shared-authentication.module';



@NgModule({
  declarations: [
    PlansDetailsComponent,
    SubscriptionsDetailsComponent,
    PlayerDetailsComponent,
    SelectPlanComponent
  ],
  imports: [
    CommonModule,
    SharedAuthenticationModule
  ], exports: [
    SharedAuthenticationModule,
    PlansDetailsComponent,
    SubscriptionsDetailsComponent,
    PlayerDetailsComponent,
    SelectPlanComponent
  ]
})
export class SharedSubscriptionsModule { }

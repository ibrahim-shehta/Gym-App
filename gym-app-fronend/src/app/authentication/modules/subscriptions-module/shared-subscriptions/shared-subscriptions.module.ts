import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlansDetailsComponent } from './components/plans-details/plans-details.component';
import { SubscriptionsDetailsComponent } from './components/subscriptions-details/subscriptions-details.component';
import { SelectPlanComponent } from './components/select-plan/select-plan.component';
import { SharedAuthenticationModule } from 'src/app/authentication/shared-authentication/shared-authentication.module';
import { MemberDetailsComponent } from './components/member-details/member-details.component';



@NgModule({
  declarations: [
    PlansDetailsComponent,
    SubscriptionsDetailsComponent,
    MemberDetailsComponent,
    SelectPlanComponent
  ],
  imports: [
    CommonModule,
    SharedAuthenticationModule
  ], exports: [
    SharedAuthenticationModule,
    PlansDetailsComponent,
    SubscriptionsDetailsComponent,
    MemberDetailsComponent,
    SelectPlanComponent
  ]
})
export class SharedSubscriptionsModule { }

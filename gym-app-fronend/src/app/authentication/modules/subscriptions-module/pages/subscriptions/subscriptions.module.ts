import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubscriptionsRoutingModule } from './subscriptions-routing.module';
import { SubscriptionsComponent } from './subscriptions/screens/subscriptions/subscriptions.component';
import { SubscriptionsFormComponent } from './subscriptions/screens/subscriptions-form/subscriptions-form.component';
import { SubscriptionViewComponent } from './subscriptions/screens/subscription-view/subscription-view.component';
import { SharedsModule } from 'src/app/shareds/shareds.module';
import { SubscriptionsFormResolverService } from './subscriptions/resolvers/subscriptions-form-resolver.service';
import { SubscriptionsViewResolverService } from './subscriptions/resolvers/subscriptions-view-resolver.service';
import { SubscriptionsResolversService } from './subscriptions/resolvers/subscriptions-resolvers.service';


@NgModule({
  declarations: [
    SubscriptionsComponent,
    SubscriptionsFormComponent,
    SubscriptionViewComponent
  ],
  imports: [
    CommonModule,
    SharedsModule,
    SubscriptionsRoutingModule
  ],
  providers: [
    SubscriptionsFormResolverService,
    SubscriptionsResolversService,
    SubscriptionsViewResolverService
  ]
})
export class SubscriptionsModule { }

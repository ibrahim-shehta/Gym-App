import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { SubscriptionsFormResolverService } from './subscriptions/resolvers/subscriptions-form-resolver.service';
import { SubscriptionsResolversService } from './subscriptions/resolvers/subscriptions-resolvers.service';
import { SubscriptionsViewResolverService } from './subscriptions/resolvers/subscriptions-view-resolver.service';
import { SubscriptionViewComponent } from './subscriptions/screens/subscription-view/subscription-view.component';
import { SubscriptionsFormComponent } from './subscriptions/screens/subscriptions-form/subscriptions-form.component';
import { SubscriptionsComponent } from './subscriptions/screens/subscriptions/subscriptions.component';


const routes: Routes = [
      {
        path: "",
        component: SubscriptionsComponent,
        canActivate: [AuthGuardService],
        resolve: { dataList: SubscriptionsResolversService },
      },
      {
        path: AuthURL.SubscriptionsForm,
        component: SubscriptionsFormComponent,
        canActivate: [AuthGuardService],
        resolve: { form: SubscriptionsFormResolverService },
      },
      {
        path: AuthURL.View,
        component: SubscriptionViewComponent,
        canActivate: [AuthGuardService],
        resolve: { form: SubscriptionsViewResolverService },
      }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubscriptionsRoutingModule { }

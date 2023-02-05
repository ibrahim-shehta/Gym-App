import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from '../../authentication.url';


const routes: Routes = [
  { path: AuthURL.Plans, loadChildren: () => import('./pages/plans/plans.module').then(m => m.PlansModule) },
  { path: AuthURL.Member, loadChildren: () => import('./pages/members/member.module').then(m => m.MemberModule) },
  { path: AuthURL.Subscriptions, loadChildren: () => import('./pages/subscriptions/subscriptions.module').then(m => m.SubscriptionsModule) },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubscriptionsModuleRoutingModule { }

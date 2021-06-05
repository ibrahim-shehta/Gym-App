import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from '../../authentication.url';


const routes: Routes = [
  { path: AuthURL.Plans, loadChildren: () => import('./pages/plans/plans.module').then(m => m.PlansModule) },
  { path: AuthURL.Players, loadChildren: () => import('./pages/players/players.module').then(m => m.PlayersModule) },
  { path: AuthURL.Subscriptions, loadChildren: () => import('./pages/subscriptions/subscriptions.module').then(m => m.SubscriptionsModule) },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubscriptionsModuleRoutingModule { }

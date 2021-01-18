import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutingUrls } from '../core/constants/RoutingUrls';
import { AuthGuardService } from '../core/service/auth-guard.service';
import { ScreensComponent } from './screens.component';

const routes: Routes = [
  { path: RoutingUrls.AUTH, loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  {
    path: RoutingUrls.SCREENS,
    component: ScreensComponent,
    children: [
      { path: '', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) }
      // {path: '', component: DashboardComponent, pathMatch: 'full', canActivate: [AuthGuardService]}
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ScreensRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutingUrls } from '../core/constants/RoutingUrls';
import { AuthGuardService } from '../core/service/auth-guard.service';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';
import { ScreensComponent } from './screens.component';

const routes: Routes = [
  { path: RoutingUrls.LOGIN.toString(), loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  {path: RoutingUrls.LOGIN.toString(),
    component: ScreensComponent,
    children: [
      {path: '', component: DashboardComponent, pathMatch: 'full', canActivate: [AuthGuardService]}
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ScreensRoutingModule { }

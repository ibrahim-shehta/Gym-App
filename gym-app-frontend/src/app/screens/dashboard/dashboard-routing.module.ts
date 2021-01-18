import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutingUrls } from 'src/app/core/constants/RoutingUrls';
import { AuthGuardService } from 'src/app/core/service/auth-guard.service';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


const routes: Routes = [
  { path: '',
    redirectTo: RoutingUrls.DASHBOARD
  },
  {
    path: RoutingUrls.DASHBOARD,
    canActivate: [AuthGuardService],
    component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }

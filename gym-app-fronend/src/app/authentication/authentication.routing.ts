import { Routes, RouterModule } from "@angular/router";
import { AuthURL } from "./authentication.url";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { SettingComponent } from "./components/setting/setting.component";
import { ProfileComponent } from "./components/profile/profile.component";
import { AuthGuardService } from "../core/services/auth-guard.service";

const RouteList: Routes = [
  { path: "", redirectTo: AuthURL.Dashboard, pathMatch: "full" },
  {
    path: AuthURL.Dashboard,
    component: DashboardComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: AuthURL.Setting,
    component: SettingComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: AuthURL.Profile,
    component: ProfileComponent,
    canActivate: [AuthGuardService],
  },

  { path: AuthURL.SubscriptionsModule, loadChildren: () => import('./modules/subscriptions-module/subscriptions-module.module').then(m => m.SubscriptionsModuleModule) },
  { path: AuthURL.ExerciseModule, loadChildren: () => import('./modules/exercises-module/exercises-module.module').then(m => m.ExercisesModuleModule) },
];

export const AuthenticationRouting = RouterModule.forChild(RouteList);

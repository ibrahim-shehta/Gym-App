import { Routes, RouterModule } from "@angular/router";
import { AuthURL } from "./authentication.url";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { SettingComponent } from "./components/setting/setting.component";
import { ProfileComponent } from "./components/profile/profile.component";
import { AuthGuardService } from "../core/services/auth-guard.service";
import { CategoriesFormResolversService } from "./pages/exercises/categories/resolvers/categories-form-resolvers.service";
import { CategoriesResolverService } from "./pages/exercises/categories/resolvers/categories-resolver.service";
import { CategoriesComponent } from "./pages/exercises/categories/screens/categories/categories.component";
import { CategoriesFormComponent } from "./pages/exercises/categories/screens/categories-form/categories-form.component";
import { ExerciseComponent } from "./pages/exercises/exercises/screens/categories/exercise.component";
import { ExerciseResolverService } from "./pages/exercises/exercises/resolvers/exercise-resolver.service";
import { ExerciseFormComponent } from "./pages/exercises/exercises/screens/categories-form/exercise-form.component";
import { ExerciseFormResolversService } from "./pages/exercises/exercises/resolvers/exercise-form-resolvers.service";
import { EquipmentComponent } from "./pages/equipment/screens/equipment/equipment.component";
import { EquipmentFormComponent } from "./pages/equipment/screens/equipment-form/equipment-form.component";
import { EquipmentResolverService } from "./pages/equipment/resolvers/equipment-resolver.service"
import { EquipmentFormResolversService } from "./pages/equipment/resolvers/equipment-form-resolvers.service"

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

  {
    path: AuthURL.ExcercisesCategory,
    children: [
      {
        path: "",
        component: CategoriesComponent,
        canActivate: [AuthGuardService],
        resolve: { dataList: CategoriesResolverService },
      },
      {
        path: AuthURL.Form,
        component: CategoriesFormComponent,
        canActivate: [AuthGuardService],
        resolve: { form: CategoriesFormResolversService },
      },
    ],
  },


  {
    path: AuthURL.Exercise,
    children: [
      {
        path: "",
        component: ExerciseComponent,
        canActivate: [AuthGuardService],
        resolve: { dataList: ExerciseResolverService },
      },
      {
        path: AuthURL.Form,
        component: ExerciseFormComponent,
        canActivate: [AuthGuardService],
        resolve: { form: ExerciseFormResolversService },
      },
    ],
  },

  {
    path: AuthURL.Equipment,
    children: [
      {
        path: "",
        component: EquipmentComponent,
        canActivate: [AuthGuardService],
        resolve: { dataList: EquipmentResolverService },
      },
      {
        path: AuthURL.Form,
        component: EquipmentFormComponent,
        canActivate: [AuthGuardService],
        resolve: { form: EquipmentFormResolversService },
      },
    ],
  },
];

export const AuthenticationRouting = RouterModule.forChild(RouteList);

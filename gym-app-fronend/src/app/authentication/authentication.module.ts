import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthenticationRouting } from './authentication.routing';
import { SharedsModule } from '../shareds/shareds.module';
import { SettingComponent } from './components/setting/setting.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PlansComponent } from './pages/plans/screens/plans/plans.component';
import { PlansFormComponent } from './pages/plans/screens/plans-form/plans-form.component';
import { PlayersComponent } from './pages/users/screens/players/players.component';
import { PlayersFormComponent } from './pages/users/screens/players-form/players-form.component';
import { SubscriptionsComponent } from './pages/subscriptions/screens/subscriptions/subscriptions.component';
import { SubscriptionsFormComponent } from './pages/subscriptions/screens/subscriptions-form/subscriptions-form.component';
import { CategoriesComponent } from './pages/exercises/categories/screens/categories/categories.component';
import { CategoriesFormComponent } from './pages/exercises/categories/screens/categories-form/categories-form.component';


@NgModule({
  declarations: [
    DashboardComponent,
    SettingComponent,
    ProfileComponent,
    PlansComponent,
    PlansFormComponent,
    PlayersComponent,
    PlayersFormComponent,
    SubscriptionsComponent,
    SubscriptionsFormComponent,
    CategoriesComponent,
    CategoriesFormComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRouting,
    SharedsModule
  ]
})
export class AuthenticationModule { }

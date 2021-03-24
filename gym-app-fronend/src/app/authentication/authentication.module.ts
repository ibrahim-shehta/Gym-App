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
import { PlansViewComponent } from './pages/plans/screens/plans-view/plans-view.component';
import { PlansDetailsComponent } from './pages/plans/components/plans-details/plans-details.component';
import { PlyersViewComponent } from './pages/users/screens/plyers-view/plyers-view.component';
import { PlayerDetailsComponent } from './pages/users/components/player-details/player-details.component';
import { SelectPlanComponent } from './pages/plans/components/select-plan/select-plan.component';
import { PlayerAttendanceComponent } from './pages/users/screens/player-attendance/player-attendance.component';
import { PlayerAttendanceHistoryComponent } from './pages/users/screens/player-attendance-history/player-attendance-history.component';
import { SubscriptionViewComponent } from './pages/subscriptions/screens/subscription-view/subscription-view.component';
import { SubscriptionsDetailsComponent } from './pages/subscriptions/components/subscriptions-details/subscriptions-details.component';


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
    CategoriesFormComponent,
    PlansViewComponent,
    PlansDetailsComponent,
    PlyersViewComponent,
    PlayerDetailsComponent,
    SelectPlanComponent,
    PlayerAttendanceComponent,
    PlayerAttendanceHistoryComponent,
    SubscriptionViewComponent,
    SubscriptionsDetailsComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRouting,
    SharedsModule
  ]
})
export class AuthenticationModule { }

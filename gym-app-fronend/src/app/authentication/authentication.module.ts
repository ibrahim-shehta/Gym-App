import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthenticationRouting } from './authentication.routing';
import { SharedsModule } from '../shareds/shareds.module';
import { SettingComponent } from './components/setting/setting.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MembersComponent } from './components/members/members.component';
import { MembersCreateComponent } from './components/members-create/members-create.component';
import { PlansComponent } from './pages/plans/screens/plans/plans.component';
import { PlansFormComponent } from './pages/plans/screens/plans-form/plans-form.component';
import { PlayersComponent } from './pages/users/screens/players/players.component';
import { PlayersFormComponent } from './pages/users/screens/players-form/players-form.component';


@NgModule({
  declarations: [
    DashboardComponent,
    SettingComponent,
    ProfileComponent,
    MembersComponent,
    MembersCreateComponent,
    PlansComponent,
    PlansFormComponent,
    PlayersComponent,
    PlayersFormComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRouting,
    SharedsModule
  ]
})
export class AuthenticationModule { }

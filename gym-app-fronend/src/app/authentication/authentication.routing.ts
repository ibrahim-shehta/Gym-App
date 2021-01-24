import {Routes , RouterModule} from '@angular/router';
import { AuthURL } from './authentication.url';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SettingComponent } from './components/setting/setting.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MembersComponent } from './components/members/members.component';
import { MembersCreateComponent } from './components/members-create/members-create.component';
import { AuthGuardService } from '../core/services/auth-guard.service';
import { PlansComponent } from './pages/plans/screens/plans/plans.component';
import { PlansFormComponent } from './pages/plans/screens/plans-form/plans-form.component';
import { PlansResolverService } from './pages/plans/resolvers/plans-resolver.service';
import { PlansFormResolversService } from './pages/plans/resolvers/plans-form-resolvers.service';
import { PlayersResolversService } from './pages/users/resolvers/players-resolvers.service';
import { PlayersComponent } from './pages/users/screens/players/players.component';
import { PlayersFormComponent } from './pages/users/screens/players-form/players-form.component';
import { PlayersFormResolverService } from './pages/users/resolvers/players-form-resolver.service';


const RouteList: Routes = [
    {path : '' , redirectTo: AuthURL.Dashboard , pathMatch: 'full'},
    {path : AuthURL.Dashboard, component: DashboardComponent, canActivate: [AuthGuardService]},
    {path : AuthURL.Setting, component: SettingComponent, canActivate: [AuthGuardService]},
    {path : AuthURL.Profile, component: ProfileComponent, canActivate: [AuthGuardService]},
    {path : AuthURL.Members, component: MembersComponent, canActivate: [AuthGuardService]},
    {path : AuthURL.MembersCreate, component: MembersCreateComponent, canActivate: [AuthGuardService]},
    {path : AuthURL.Plans,
      children: [
          {path: '', component: PlansComponent, canActivate: [AuthGuardService], resolve: {dataList: PlansResolverService}},
          {path: AuthURL.PlansForm  ,component: PlansFormComponent, canActivate: [AuthGuardService], resolve: {entity: PlansFormResolversService}}

      ]
    },
    {path : AuthURL.Players,
        children: [
            {path: '', component: PlayersComponent, canActivate: [AuthGuardService], resolve: {dataList: PlayersResolversService}},
            {path: AuthURL.PlayersForm  ,component: PlayersFormComponent, canActivate: [AuthGuardService], resolve: {entity: PlayersFormResolverService}}

        ]

    }
];

export const AuthenticationRouting = RouterModule.forChild(RouteList);


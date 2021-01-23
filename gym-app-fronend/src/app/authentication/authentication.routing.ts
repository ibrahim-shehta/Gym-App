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

    }
];

export const AuthenticationRouting = RouterModule.forChild(RouteList);


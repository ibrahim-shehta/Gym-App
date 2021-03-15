import {Routes , RouterModule} from '@angular/router';
import { AppURL } from './app.url';
import { DashboardComponent } from './authentication/components/dashboard/dashboard.component';

const RouteList: Routes = [
    {path : '' , redirectTo: AppURL.UnAuth , pathMatch: 'full'},
    {path : AppURL.UnAuth , loadChildren: () => import('./un-auth-user/un-auth-user.module').then(m => m.UnAuthUserModule)},
    {path : AppURL.Authen , loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule)},
    {path: '**', component: DashboardComponent}
];

export const AppRouting = RouterModule.forRoot(RouteList);


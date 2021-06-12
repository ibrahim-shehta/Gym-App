import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RolesComponent } from './screens/roles/roles.component';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { RolesResolverService } from './resolvers/roles-resolver.service';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { RolesFormComponent } from './screens/roles-form/roles-form.component';
import { RolesFormResolverService } from './resolvers/roles-form-resolver.service';


const routes: Routes = [
  {
    path: "",
    component: RolesComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: RolesResolverService },
  },
  {
    path: AuthURL.Form,
    component: RolesFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: RolesFormResolverService },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RolesRoutingModule { }

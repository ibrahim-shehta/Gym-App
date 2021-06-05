import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { PlansFormResolversService } from './resolvers/plans-form-resolvers.service';
import { PlansResolverService } from './resolvers/plans-resolver.service';
import { PlansFormComponent } from './screens/plans-form/plans-form.component';
import { PlansViewComponent } from './screens/plans-view/plans-view.component';
import { PlansComponent } from './screens/plans/plans.component';


const routes: Routes = [
  {
    path: "",
    component: PlansComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: PlansResolverService },
  },
  {
    path: AuthURL.PlansForm,
    component: PlansFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: PlansFormResolversService },
  },
  {
    path: AuthURL.View,
    component: PlansViewComponent,
    canActivate: [AuthGuardService],
    resolve: { form: PlansFormResolversService },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlansRoutingModule { }

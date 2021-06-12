import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { EmployeeFormResolverService } from './resolvers/employee-form-resolver.service';
import { EmployeeResolversService } from './resolvers/employee-resolvers.service';
import { EmployeeFormComponent } from './screens/employee-form/employee-form.component';
import { EmployeeViewComponent } from './screens/employee-view/employee-view.component';
import { EmployeeComponent } from './screens/employee/employee.component';

const routes: Routes = [

  {
    path: "",
    component: EmployeeComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: EmployeeResolversService },
  },
  {
    path: AuthURL.PlayersForm,
    component: EmployeeFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: EmployeeFormResolverService },
  }, {
    path: AuthURL.View,
    component: EmployeeViewComponent,
    canActivate: [AuthGuardService],
    resolve: { form: EmployeeFormResolverService },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }

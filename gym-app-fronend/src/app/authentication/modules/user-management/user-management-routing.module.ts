import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from '../../authentication.url';


const routes: Routes = [
  { path: AuthURL.Roles, loadChildren: () => import('./pages/roles/roles.module').then(m => m.RolesModule) },
  { path: AuthURL.Employees, loadChildren: () => import('./pages/employee/employee.module').then(m => m.EmployeesModule) },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeRoutingModule } from './employee-routing.module';
import { SharedUserManagementModule } from '../../shared-user-management/shared-user-management.module';
import { EmployeeService } from './services/employee.service';
import { EmployeeResolversService } from './resolvers/employee-resolvers.service';
import { EmployeeFormResolverService } from './resolvers/employee-form-resolver.service';
import { EmployeeComponent } from './screens/employee/employee.component';
import { EmployeeFormComponent } from './screens/employee-form/employee-form.component';
import { EmployeeViewComponent } from './screens/employee-view/employee-view.component';
import { SharedSubscriptionsModule } from '../../../subscriptions-module/shared-subscriptions/shared-subscriptions.module';




@NgModule({
  declarations: [
    EmployeeComponent,
    EmployeeFormComponent,
    EmployeeViewComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    SharedUserManagementModule,
    SharedSubscriptionsModule
  ],
  providers: [
    EmployeeService,
    EmployeeResolversService,
    EmployeeFormResolverService
  ]
})
export class EmployeesModule { }

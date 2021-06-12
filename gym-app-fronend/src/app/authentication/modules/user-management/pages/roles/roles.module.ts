import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RolesRoutingModule } from './roles-routing.module';
import { RolesComponent } from './screens/roles/roles.component';
import { RolesFormComponent } from './screens/roles-form/roles-form.component';
import { SharedUserManagementModule } from '../../shared-user-management/shared-user-management.module';
import { RolesResolverService } from './resolvers/roles-resolver.service';
import { RolesFormResolverService } from './resolvers/roles-form-resolver.service';
import { PermissionService } from './service/permission.service';


@NgModule({
  declarations: [RolesComponent, RolesFormComponent],
  imports: [
    CommonModule,
    RolesRoutingModule,
    SharedUserManagementModule
  ],
  providers: [
    PermissionService,
    RolesResolverService,
    RolesFormResolverService
  ]
})
export class RolesModule { }

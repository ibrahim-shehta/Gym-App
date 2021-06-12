import { Component, OnInit } from '@angular/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Role } from '../../model/Role';
import { Router, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { RolesService } from '../../service/roles.service';
import { Permission } from '../../model/Permission';

@Component({
  selector: 'app-roles-form',
  templateUrl: './roles-form.component.html',
  styleUrls: ['./roles-form.component.css']
})
export class RolesFormComponent extends BaseFormCompnent<Role> implements OnInit {

  permissions: Permission[]
  selectedPermissions: Permission[] = []
  perObj: any;
  selectedPermissionObj: any;
  Object = Object;
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private rolesService :RolesService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Role();
  }

  ngOnInit() :void {
    this.initFormMode();
    this.getPermissionData(this.permissions);
    this.getSelectedPermissionObject(this.selectedPermissions);
  }

  getResolverData() {
    this.permissions = this.activatedRoute.snapshot.data.form.permissions.data;
    const entity = this.activatedRoute.snapshot.data.form.entity;
    if (entity) {
      this.entity = entity.data;
      this.selectedPermissions = this.entity.permissions;
    }

    console.log(this.entity)
    console.log(this.permissions)
    console.log(this.selectedPermissions)
  }


  getPermissionData(permissions: any[]) {
      var map = {},
        node,
        roots = {},
        i;

      for (i = 0; i < permissions.length; i++) {
        map[permissions[i].id] = i;
        permissions[i].children = {};
      }
      for (i = 0; i < permissions.length; i += 1) {
        node = permissions[i];
        if (node.parentId) {
          permissions[map[node.parentId]].children[node.code] = node;
        } else {
          roots[node.code] = node;
        }
      }
      this.perObj = roots;
      console.log(this.perObj)
  }

  getSelectedPermissionObject(permissions: any[]) {
    var map = {},
      i;

    for (i = 0; i < permissions.length; i++) {
      map[permissions[i].code] = i;
    }

    this.selectedPermissionObj = map;
    console.log(this.selectedPermissionObj)
}

  getService() :RolesService {
    return this.rolesService;
  }

  //newselectedPermissions: Permission[] = [];
  valus: any[] = [[]];
  onSelectPermission(per) {
    console.log(per);
    console.log(this.selectedPermissions)
    const index = this.selectedPermissions.findIndex(item => item.id == per.id);
    if (index < 0) {
      this.selectedPermissions.push(per);
    } else {
      this.selectedPermissions.splice(index, 1);
    }

    this.entity.permissions = this.selectedPermissions;
    console.log(this.selectedPermissions, index, this.entity)
  }

}

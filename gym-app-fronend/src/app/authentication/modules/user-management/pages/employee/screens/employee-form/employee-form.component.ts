import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { Employee } from 'src/app/core/model/User';
import { NotificationService } from 'src/app/core/services/notification.service';
import { EmployeeService } from '../../services/employee.service';
import { Role } from 'src/app/authentication/modules/user-management/pages/roles/model/Role';

@Component({
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent extends BaseFormCompnent<Employee> implements OnInit {
  roles: Role[] = [];
  selectedRoles : Role[] = [];
  selectedId: number;
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private employeeService :EmployeeService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Employee();
  }

  ngOnInit() :void {
    this.initFormMode();
  }

  getResolverData() {
    this.roles = this.activatedRoute.snapshot.data.form.roles.data;
    const entity = this.activatedRoute.snapshot.data.form.entity;
    if (entity) {
      this.entity = entity.data;
      this.selectedId = this.entity.roles[0] ? this.entity.roles[0].id : null;
      this.isEditMode = true;
    }
  }


  onChangeRole(id) {
    this.entity.roles = [this.roles.find(item => item.id == id)];
    console.log(this.selectedRoles);
  }

  getService() :EmployeeService {
    return this.employeeService;
  }
}

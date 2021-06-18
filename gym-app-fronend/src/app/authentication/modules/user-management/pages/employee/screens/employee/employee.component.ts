import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableWithStatusComponent } from 'src/app/core/model/BaseTableWithStatusComponent';
import { EmployeeList } from 'src/app/core/model/User';
import { NotificationService } from 'src/app/core/services/notification.service';
import { EmployeeService } from '../../services/employee.service';
@Component({
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent extends BaseTableWithStatusComponent<EmployeeList> implements OnInit, OnDestroy {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public employeeService: EmployeeService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

   ngOnInit() :void  {
    this.baseInit();
  }

  onClickAttendace(id) {
      this.resetState = false;
      this.router.navigate([AuthURL.Attendance], {relativeTo: this.activatedRoute, state: {id: id}});
  }
  getService() :EmployeeService {
    return this.employeeService;
  }

  getFilterArr() {
    return ["name", "username", "email", "mobile"]
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

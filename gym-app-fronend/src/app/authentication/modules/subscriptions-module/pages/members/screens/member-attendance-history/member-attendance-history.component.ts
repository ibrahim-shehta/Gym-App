import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { MemberAttendanceList } from '../../model/MemberAttendance';
import { AttendanceService } from '../../services/attendance.service';

@Component({
  selector: 'app-member-attendance-history',
  templateUrl: './member-attendance-history.component.html',
  styleUrls: ['./member-attendance-history.component.css']
})
export class MemberAttendanceHistoryComponent extends BaseTableComponent<MemberAttendanceList> implements OnInit {

  back :boolean = false;
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public _componentService: AttendanceService
  ) {
    super(router, activatedRoute, notificationService, translateService);
    if (!this.router.getCurrentNavigation().extras.state)
          this.back = true;
  }

  ngOnInit(): void {
    if (!this.back)
      this.baseInit();
  }

  getService() :AttendanceService {
    return this._componentService;
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

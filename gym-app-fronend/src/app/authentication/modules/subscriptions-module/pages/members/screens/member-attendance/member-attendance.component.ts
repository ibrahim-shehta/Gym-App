import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { SubscriptionsService } from 'src/app/authentication/modules/subscriptions-module/pages/subscriptions/subscriptions/services/subscriptions.service';
import { ResponseStatus } from 'src/app/core/constants/response-status-enum';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { MemberAttendance } from '../../model/MemberAttendance';
import { AttendanceService } from '../../services/attendance.service';
@Component({
  selector: 'app-member-attendance',
  templateUrl: './member-attendance.component.html',
  styleUrls: ['./member-attendance.component.css']
})
export class MemberAttendanceComponent extends BaseFormCompnent<MemberAttendance> implements OnInit {
  userId;
  excercisesCategories :any[] = [];
  activeSubscription :any = {user: {}};
  showPaymentRemain :boolean = false;
  showSubscriptionDetails :boolean = false;
  remainAmount;

  back :boolean = false;
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private _componentService :AttendanceService,
    private subscriptionService: SubscriptionsService
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new MemberAttendance();
        if (this.router.getCurrentNavigation().extras.state)
          this.entity.user.id = this.router.getCurrentNavigation().extras.state.id;
        else
          this.back = true;
  }

  ngOnInit() :void {
    if (this.back)
      this.goBack();
    else
      this.getResolverData();
  }

  getResolverData() {
    this.excercisesCategories = this.activatedRoute.snapshot.data.form.categories.data;
    this.activeSubscription = this.activatedRoute.snapshot.data.form.subscription.data;
    this.remainAmount = this.activeSubscription.requiredAmount - this.activeSubscription.paidAmount;
  }

  add(entity) :void {
    this.getService().insert(entity).subscribe(res => {
      this.insertSuccessMsg();
      this.goBack();
    }, err => {
      this.backendError(err.error);
      if(err.error.status == ResponseStatus[ResponseStatus.CONFLICT]) {
        this.insertSuccessMsg();
        this.goBack();
      }
    })
  }

  payRemainAmount() {
    const currentPaid = this.activeSubscription.paidAmount;
    this.activeSubscription.paidAmount = this.remainAmount;
    this.subscriptionService.payRemainAmount(this.activeSubscription).subscribe(res => {
        this.activeSubscription.paidAmount  += currentPaid;
        this.remainAmount = this.activeSubscription.requiredAmount - this.activeSubscription.paidAmount;
        this.showPaymentRemain = false;
        this.notificationService.showSuccess('', this.translateService.instant('COMMON.SAVE_SUCCESS'));
    })
  }

  getService() :AttendanceService {
    return this._componentService;
  }
}

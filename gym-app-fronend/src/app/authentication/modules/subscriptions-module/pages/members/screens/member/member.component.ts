import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { MemberList } from 'src/app/core/model/User';
import { NotificationService } from 'src/app/core/services/notification.service';
import { MemberService } from '../../services/member.service';
@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent extends BaseTableComponent<MemberList> implements OnInit, OnDestroy {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public memberService: MemberService
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
  getService() :MemberService {
    return this.memberService;
  }

  getFilterArr() {
    return ["name", "username", "email", "mobile"]
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

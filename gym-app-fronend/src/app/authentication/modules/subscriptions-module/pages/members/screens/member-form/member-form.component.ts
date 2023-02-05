import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { Member } from 'src/app/core/model/User';
import { NotificationService } from 'src/app/core/services/notification.service';
import { MemberService } from '../../services/member.service';

@Component({
  selector: 'app-players-form',
  templateUrl: './member-form.component.html',
  styleUrls: ['./member-form.component.scss']
})
export class MemberFormComponent extends BaseFormCompnent<Member> implements OnInit {
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private memberService :MemberService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Member();
  }

  ngOnInit() :void {
    this.initFormMode();
  }

  getService() :MemberService {
    return this.memberService;
  }
}

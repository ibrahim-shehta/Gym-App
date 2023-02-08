import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Role } from 'src/app/authentication/modules/user-management/pages/roles/model/Role';
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

  roles: Role[] = [];
  selectedRoles : Role[] = [];
  selectedId: number;

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
  
  getService() :MemberService {
    return this.memberService;
  }
}

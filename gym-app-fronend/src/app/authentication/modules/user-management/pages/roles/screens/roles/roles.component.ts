import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NotificationService } from 'src/app/core/services/notification.service';
import { TranslateService } from '@ngx-translate/core';
import { RolesService } from '../../service/roles.service';
import { BaseTableWithAuditComponent } from 'src/app/core/model/BaseTableWithAuditComponent';
import { Role } from '../../model/Role';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent extends BaseTableWithAuditComponent<Role> implements OnInit, OnDestroy {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public rolesService: RolesService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :RolesService {
    return this.rolesService;
  }

  getFormUrl() :string {
    return this.AuthURL.PlansForm;
  }

  ngOnDestroy() {
    super.onDestroy();
  }

}

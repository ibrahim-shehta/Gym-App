import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlansService } from '../../services/plans.service';


@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent extends BaseTableComponent<any> implements OnInit, OnDestroy {
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public planService: PlansService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :PlansService {
    return this.planService;
  }

  getFormUrl() :string {
    return AuthURL.PlansForm;
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseTableWithStatusComponent } from 'src/app/core/model/BaseTableWithStatusComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { SubscriptionList } from '../../model/Subscription';
import { SubscriptionsService } from '../../services/subscriptions.service';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent extends BaseTableWithStatusComponent<SubscriptionList> implements OnInit, OnDestroy {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public _componentService: SubscriptionsService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

   ngOnInit() :void  {
    this.baseInit();
  }

  getFilterArr() {
    return ["name", "subscriptionNumber"];
  }

  getService() :SubscriptionsService {
    return this._componentService;
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

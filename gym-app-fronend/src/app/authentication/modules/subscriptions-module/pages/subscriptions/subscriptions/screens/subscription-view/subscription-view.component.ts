import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseViewComponent } from 'src/app/core/model/BaseViewComponent';
import { NotificationService } from 'src/app/core/services/notification.service';

@Component({
  selector: 'app-subscription-view',
  templateUrl: './subscription-view.component.html',
  styleUrls: ['./subscription-view.component.css']
})
export class SubscriptionViewComponent extends BaseViewComponent implements OnInit {

  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
  ) {
    super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit(): void {
    this.getResolverData();
  }

}

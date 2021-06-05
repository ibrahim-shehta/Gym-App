import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseViewComponent } from 'src/app/core/model/BaseViewComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
@Component({
  selector: 'app-plans-view',
  templateUrl: './plans-view.component.html',
  styleUrls: ['./plans-view.component.css']
})
export class PlansViewComponent extends BaseViewComponent implements OnInit {

  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() :void {
    this.getResolverData();
  }

}

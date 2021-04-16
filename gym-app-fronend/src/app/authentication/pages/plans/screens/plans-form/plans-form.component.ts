import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Plan } from '../../model/Plan';
import { PlansService } from '../../services/plans.service';

@Component({
  selector: 'app-plans-form',
  templateUrl: './plans-form.component.html',
  styleUrls: ['./plans-form.component.scss']
})
export class PlansFormComponent extends BaseFormCompnent<Plan> implements OnInit {

  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private plansService :PlansService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Plan();
  }

  ngOnInit() :void {
    this.modeInit();
  }

  getService() :PlansService {
    return this.plansService;
  }

}

import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Equipment } from '../../models/Equipment';
import { EquipmentService } from '../../services/equipment-service';
import { BaseTableWithStatusComponent } from 'src/app/core/model/BaseTableWithStatusComponent';


@Component({
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.css']
})
export class EquipmentComponent extends BaseTableWithStatusComponent<Equipment> implements OnInit, OnDestroy {
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public _componentService :EquipmentService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :EquipmentService {
    return this._componentService;
  }

  getFilterArr() {
    return ['name', 'code']
  }

  ngOnDestroy() {
    super.onDestroy();
  }

}

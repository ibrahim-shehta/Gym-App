import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Equipment } from '../../models/Equipment';
import { EquipmentService } from '../../services/equipment-service';


@Component({
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.css']
})
export class EquipmentComponent extends BaseTableComponent<Equipment> implements OnInit, OnDestroy {
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public equipmentService :EquipmentService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :EquipmentService {
    return this.equipmentService;
  }

  getFormUrl() :string {
    return AuthURL.Form;
  }

  getFilterArr() {
    return ['name', 'code']
  }
  ngOnDestroy() {
    super.onDestroy();
  }

}

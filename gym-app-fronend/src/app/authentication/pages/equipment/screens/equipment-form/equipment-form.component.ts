import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Equipment } from 'src/app/authentication/pages/equipment/models/Equipment';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { EquipmentService } from '../../services/equipment-service';


@Component({
  templateUrl: './equipment-form.component.html',
  styleUrls: ['./equipment-form.component.scss']
})
export class EquipmentFormComponent extends BaseFormCompnent<Equipment> implements OnInit {
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private equipmentService :EquipmentService
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Equipment();

  }

  ngOnInit() :void {
    this.entity = new Equipment();
    this.modeInit();
  }

  getService() :EquipmentService {
    return this.equipmentService;
  }

}

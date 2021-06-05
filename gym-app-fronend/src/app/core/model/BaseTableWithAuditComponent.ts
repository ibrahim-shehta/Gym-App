import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { AuditEntity } from "./AuditEntity";
import { BaseAuditService } from "./BaseAuditService";
import { BaseEntity } from "./BaseEntity";
import { BaseTableComponent } from "./BaseTableComponent";

export abstract class BaseTableWithAuditComponent<T extends BaseEntity> extends BaseTableComponent<T> {

  audit :AuditEntity;
  showAuditDialog :boolean = false;

  abstract  getService() :BaseAuditService<any, any>;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  onShowAuditHandler(entity :BaseEntity) {
    this.getService().getAudit(entity.id).subscribe(res => {
      this.audit = res.data;
      this.showAuditDialog = true;
    })
  }

}

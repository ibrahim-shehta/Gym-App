import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";
import { Baseservice } from "./BaseService";

export abstract class BaseViewComponent extends BaseComponent {
  entity: any = {};

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService: TranslateService
  ) {
    super(notificationService, translateService);
  }

  getResolverData() {
    const resolverDate = this.activatedRoute.snapshot.data.form;
    if (resolverDate) {
      this.entity = resolverDate.data;
      if (!this.entity)
        this.entity = resolverDate.entity.data;
    } else {
      this.goBack();
    }
  }

  goBack(): void {
    this.router.navigate(["../"], { relativeTo: this.activatedRoute });
  }

  getService() :Baseservice<any,any> {
    return null;
  }

}

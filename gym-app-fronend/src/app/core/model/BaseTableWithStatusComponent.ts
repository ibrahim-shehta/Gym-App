import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { BaseEntity } from "./BaseEntity";
import { BaseServiceWithStatus } from "./BaseServiceWithStatus";
import { BaseTableComponent } from "./BaseTableComponent";

export abstract class BaseTableWithStatusComponent<T extends BaseEntity> extends BaseTableComponent<T> {

  statusList :[] = [];
  abstract  getService() :BaseServiceWithStatus<any, any>;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  onSelectStatusHandler(event) {
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().status = event != -1 ? event : null;
    this.getPage();
  }

  getResolverData() :void {
    this.statusList = this.activatedRoute.snapshot.data.dataList[0].data;
    this.dataList = this.activatedRoute.snapshot.data.dataList[1].data;
    this.totalRows = this.activatedRoute.snapshot.data.dataList[1].totalRows;
    this.getService().totalRows = this.totalRows;
  }

  onDestroy() {
    if (this.resetState)
      this.getService().status = this.getService().getDefaultStatus();
    super.onDestroy();
  }
}

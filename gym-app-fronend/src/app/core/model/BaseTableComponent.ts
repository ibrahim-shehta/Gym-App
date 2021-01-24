import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";
import { Baseservice } from "./BaseService";

export abstract class BaseTableComponent extends BaseComponent {
  dataList: any[] = [];
  totalRows: number;
  currentPage :number = 1;
  directionLinks: boolean = false;
  boundaryLinks: boolean = true;
  firstText: string = this.translateService.instant('COMMON.FIRST');
  lastText: string = this.translateService.instant('COMMON.LAST');
  maxSize: number = 10;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {
        super(notificationService, translateService);
        this.init();
  }

  private init() {
    this.firstText = this.translateService.instant('COMMON.FIRST');
    this.lastText = this.translateService.instant('COMMON.LAST');
  }
  abstract getPage() :void;

  abstract  getService() :Baseservice;

  pageChanged(event: any): void {
    if (event.page == (this.getService().filterDataWithPaginationAndSort.page + 1)) {
      return;
    }
    this.getService().filterDataWithPaginationAndSort.page = event.page - 1;
    this.getPage();
  }

  search() {
    this.currentPage = 1;
    this.getService().isClickSearch = true;
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().filterDataWithPaginationAndSort.filterMap = {
      name: this.getService().searchText,
    };
    this.getPage();
  }

  stopSearch() {
    this.currentPage = 1;
    this.getService().isClickSearch = false;
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().searchText = '';
    this.getService().filterDataWithPaginationAndSort.filterMap = {};
    this.getPage();
  }
}

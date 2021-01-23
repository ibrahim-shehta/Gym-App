import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { PageChangedEvent } from "ngx-bootstrap";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";
import { FilterDataWithPaginationAndSort } from "./FilterDataWithPaginationAndSort";

export class BaseTableComponent extends BaseComponent {
  filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
  searchText;
  isClickSearch;
  dataList: any[] = [];
  totalRows: number;
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
  getPage() {}

  pageChanged(event: PageChangedEvent): void {
    this.filterDataWithPaginationAndSort.page = event.page - 1;
    this.getPage();
  }

  search() {
    this.isClickSearch = true;
    this.filterDataWithPaginationAndSort.page = 0;
    this.filterDataWithPaginationAndSort.filterMap = {
      name: this.searchText,
    };
    this.getPage();
  }

  stopSearch() {
    this.isClickSearch = false;
    this.filterDataWithPaginationAndSort.page = 0;
    this.filterDataWithPaginationAndSort.filterMap = {};
    this.getPage();
  }
}

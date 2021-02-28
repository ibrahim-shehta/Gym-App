import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";
import { FilterMap } from "./FilterDataWithPaginationAndSort";

export abstract class BaseTableComponent extends BaseComponent {
  dataList: any[] = [];
  totalRows: number = 0;
  currentPage :number = 1;
  resetState :boolean = true;
  abstract  getFormUrl() :string;


  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {
        super(notificationService, translateService);
  }

  baseInit() :void {
    this.resetState = true;
    this.restorePagination();
    this.getResolverData();
  }

  restorePagination() :void {
    this.currentPage = this.getService().filterDataWithPaginationAndSort.page + 1;
    this.totalRows = this.getService().totalRows;
  }

  getResolverData() :void {
    this.dataList = this.activatedRoute.snapshot.data.dataList.data;
    this.totalRows = this.activatedRoute.snapshot.data.dataList.totalRows;
    this.getService().totalRows = this.totalRows;
  }

  getPage() :void {
    this.getService().filterWithPagination().subscribe(res => {
      this.dataList = res.data;
      this.totalRows = res.totalRows;
      this.getService().totalRows = res.totalRows;
    }, err => {
      this.backendError(err.error);
    });
  }

  pageChanged(event: any): void {
    if (event.page == (this.getService().filterDataWithPaginationAndSort.page + 1)) {
      return;
    }
    this.getService().filterDataWithPaginationAndSort.page = event.page - 1;
    this.getPage();
  }

  search() :void {
    this.currentPage = 1;
    this.getService().isClickSearch = true;
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().filterDataWithPaginationAndSort.filterMap = this.getFilterMap();
    this.getPage();
  }

  private getFilterMap() :FilterMap{
    const filterMap = new FilterMap();
    this.getFilterArr().forEach(item => {
      filterMap[item] =  this.getService().searchText
    })
    return filterMap;
  }

  getFilterArr() :string[] {
    return ["name"];
  }

  stopSearch() :void {
    this.currentPage = 1;
    this.getService().isClickSearch = false;
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().searchText = '';
    this.getService().filterDataWithPaginationAndSort.filterMap = {};
    this.getPage();
  }
  add() :void {
    this.router.navigate([this.getFormUrl()], {relativeTo: this.activatedRoute});
  }

 edit(id) :void {
   this.resetState = false;
   this.router.navigate([this.getFormUrl()], {relativeTo: this.activatedRoute, state: {id: id}});
 }

 onDestroy() {
  if (this.resetState) {
    this.getService().isClickSearch = false;
    this.getService().filterDataWithPaginationAndSort.page = 0;
    this.getService().searchText = '';
    this.getService().filterDataWithPaginationAndSort.filterMap = {};
  }
}
}

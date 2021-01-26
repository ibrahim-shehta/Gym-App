import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { FilterDataWithPaginationAndSort } from "./FilterDataWithPaginationAndSort";

export abstract  class Baseservice {
  filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
  totalRows :number;
  searchText;
  isClickSearch;

  constructor(public http: HttpClient) {}

  abstract getBaseUrl() :string;


  filterWithPagination() :Observable<any> {
    return this.http.post(this.getBaseUrl() + '/filter' , this.filterDataWithPaginationAndSort);
  }

  filterWithCustomPagination(filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort) :Observable<any> {
    return this.http.post(this.getBaseUrl() + '/filter' , filterDataWithPaginationAndSort);
  }

  add(plan :any) :Observable<any> {
    return this.http.post(this.getBaseUrl() , plan);
  }

  edit(plan :any) :Observable<any> {
    return this.http.put(this.getBaseUrl() , plan);
  }

  getById(id) :Observable<any> {
    return this.http.get(this.getBaseUrl() + '/' + id);
  }

  getAll() :Observable<any> {
    return this.http.get(this.getBaseUrl());
  }

}

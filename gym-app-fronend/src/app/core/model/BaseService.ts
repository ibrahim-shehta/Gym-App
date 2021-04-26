import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { FilterDataWithPaginationAndSort, FilterMap } from "./FilterDataWithPaginationAndSort";

export abstract  class Baseservice<L, E> {
  filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
  totalRows :number;
  searchText;
  isClickSearch;

  constructor(public http: HttpClient) {}

  abstract getBaseUrl() :string;


  filterWithPagination() :Observable<L> {
    return this.http.post<L>(this.getBaseUrl() + '/paginated-filter' , this.filterDataWithPaginationAndSort);
  }

  filterWithCustomPagination(filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort) :Observable<L> {
    return this.http.post<L>(this.getBaseUrl() + '/paginated-filter' , filterDataWithPaginationAndSort);
  }

  filterAllData(filterMap: FilterMap ) :Observable<L> {
    return this.http.post<L>(this.getBaseUrl() + '/all-filter' , filterMap);
  }

  add(entity :any) :Observable<E> {
    return this.http.post<E>(this.getBaseUrl() , entity);
  }

  edit(entity :any) :Observable<E> {
    return this.http.put<E>(this.getBaseUrl() , entity);
  }

  getById(id) :Observable<E> {
    return this.http.get<E>(this.getBaseUrl() + '/' + id);
  }

  getAll() :Observable<L> {
    return this.http.get<L>(this.getBaseUrl());
  }

}

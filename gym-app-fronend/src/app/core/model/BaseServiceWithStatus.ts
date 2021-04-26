import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Baseservice } from "./BaseService";

export abstract class BaseServiceWithStatus<L, E> extends Baseservice<L, E> {

  status :any = null;

  constructor(public http: HttpClient) {
    super(http);
    this.status = this.getDefaultStatus();

  }

  getDefaultStatus() {
    return 0;
  };

  filterWithPagination() :Observable<L> {
    if (this.status >= 0) {
      this.filterDataWithPaginationAndSort.filterMap['status'] = this.status;
    } else {
      delete this.filterDataWithPaginationAndSort.filterMap['status'];
    }
    return this.http.post<L>(this.getBaseUrl() + '/paginated-filter' , this.filterDataWithPaginationAndSort);
  }
}

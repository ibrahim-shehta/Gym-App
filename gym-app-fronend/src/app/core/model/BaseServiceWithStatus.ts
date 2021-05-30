import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { lookupTypeCode } from "../constants/lookup-type-code.enum";
import { Baseservice } from "./BaseService";
import { Lookup } from "./Lookup";

export abstract class BaseServiceWithStatus<L, E> extends Baseservice<L, E> {
  baseStatusUrl = environment.baseUrl + "/lookup";
  status :any = null;

  constructor(public http: HttpClient) {
    super(http);
    this.status = this.getDefaultStatus();

  }

  getStatusList(code :lookupTypeCode) :Observable<Lookup> {
    return this.http.get<Lookup>(this.baseStatusUrl +  `/${lookupTypeCode[code].toLowerCase()}`)
  }

  filterWithPagination() :Observable<L> {
    console.log(this.status);
    if (this.status != null && (this.status == 0 || this.status != -1)) {
      this.filterDataWithPaginationAndSort.filterMap['status'] = this.status;
    } else {
      delete this.filterDataWithPaginationAndSort.filterMap['status'];
    }
    return this.http.post<L>(this.getBaseUrl() + '/paginated-filter' , this.filterDataWithPaginationAndSort);
  }

  updateStatus(entity) {
    return this.http.put(this.getBaseUrl() + '/status', entity);
  }

  getDefaultStatus(): any {
    return 1;
  };
}

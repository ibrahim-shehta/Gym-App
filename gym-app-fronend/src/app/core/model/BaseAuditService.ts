import { HttpClient } from "@angular/common/http";
import { Baseservice } from "./BaseService";
import { Observable } from 'rxjs';
import { AuditEntity } from "./AuditEntity";

export abstract class BaseAuditService<L, E> extends Baseservice<L, E> {

  constructor(public http: HttpClient) {
    super(http);
  }

  getAudit(id: number) :Observable<{data: AuditEntity}>{
    return this.http.get<{data: AuditEntity}>(this.getBaseUrl() + '/audit/' + id);
  }
}

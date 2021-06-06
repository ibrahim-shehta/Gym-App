import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BaseServiceWithStatus } from "src/app/core/model/BaseServiceWithStatus";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsService extends BaseServiceWithStatus<any, any> {
  baseUrl = environment.baseUrl + "/subscription";

  constructor(public http: HttpClient) {
    super(http);
  }

  getBaseUrl(): string {
    return this.baseUrl;
  }

  getDefaultStatus(): any {
    return 3;
  };

  getInProgressSubscription(userId) {
    return this.http.get(this.baseUrl + "/" + userId + "/in-progress-subscription");
  }

  payRemainAmount(obj) {
    return this.http.put(this.baseUrl + "/remain-amount", obj);
  }

}

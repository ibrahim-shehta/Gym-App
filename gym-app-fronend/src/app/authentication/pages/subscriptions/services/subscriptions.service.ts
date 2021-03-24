import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BaseServiceWithStatus } from "src/app/core/model/BaseServiceWithStatus";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class SubscriptionsService extends BaseServiceWithStatus {
  baseUrl = environment.baseUrl + "/subscription";

  constructor(public http: HttpClient) {
    super(http);
  }

  getBaseUrl(): string {
    return this.baseUrl;
  }

  getStatusList() {
    return this.http.get(this.baseUrl + "/status-list");
  }

  getInProgressSubscription(userId) {
    return this.http.get(this.baseUrl + "/" + userId + "/in-progress-subscription");
  }

  payRemainAmount(obj) {
    return this.http.put(this.baseUrl + "/remain-amount", obj);
  }

}

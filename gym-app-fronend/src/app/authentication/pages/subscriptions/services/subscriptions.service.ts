import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { env } from 'process';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsService extends Baseservice{

baseUrl = environment.baseUrl + '/subscription'

constructor(public http :HttpClient) {
  super(http);
}

getBaseUrl(): string {
  return this.baseUrl;
}

}

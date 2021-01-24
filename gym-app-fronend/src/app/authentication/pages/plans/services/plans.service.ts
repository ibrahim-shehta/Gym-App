import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlansService extends Baseservice {

  baseUrl = environment.baseUrl + '/plan';

  constructor(public http :HttpClient) {
    super(http);
   }

   getBaseUrl() :string {
     return this.baseUrl;
   }

}

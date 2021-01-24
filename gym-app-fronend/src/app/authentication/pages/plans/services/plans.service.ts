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


  constructor(private http :HttpClient) {
    super();
   }

  filterWithPagination() :Observable<any> {
    return this.http.post(this.baseUrl + '/local/all/filter' , this.filterDataWithPaginationAndSort);
  }

  add(plan :any) :Observable<any> {
    return this.http.post(this.baseUrl , plan);
  }

  edit(plan :any) :Observable<any> {
    return this.http.put(this.baseUrl , plan);
  }

  getById(id) :Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }


}

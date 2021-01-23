import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageKeys } from 'src/app/core/constants/StorageKeys';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlansService {

  baseUrl = environment.baseUrl + '/plan';


  constructor(private http :HttpClient) { }

  filterWithPagination(filter :any) :Observable<any> {
    return this.http.post(this.baseUrl + '/local/all/filter' , filter);
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

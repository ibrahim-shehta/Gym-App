import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Employee, EmployeeList } from 'src/app/core/model/User';
import { BaseServiceWithStatus } from 'src/app/core/model/BaseServiceWithStatus';
@Injectable()
export class EmployeeService extends BaseServiceWithStatus<Employee, EmployeeList> {

baseUrl = environment.baseUrl + '/employee'

constructor(public http :HttpClient) {
  super(http);
}


uploadUserProfileImage(file: File): Observable<HttpEvent<any>>  {
  const formData: FormData = new FormData();
  formData.append('file', file);
  const req = new HttpRequest('POST', `${this.baseUrl}/upload/profile`, formData, {
    reportProgress: true,
    responseType: 'json'
  });
  return this.http.request(req);
}

getBaseUrl(): string {
  return this.baseUrl;
}



}

import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PlayersService extends Baseservice<any, any> {

baseUrl = environment.baseUrl + '/player'

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

import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService  {

    baseUrl = environment.baseUrl + '/upload';

    constructor(public http :HttpClient) {}

    uploadUserProfileImage(file: File): Observable<HttpEvent<any>>  {
      const formData: FormData = new FormData();
      formData.append('file', file);
      const req = new HttpRequest('POST', `${this.baseUrl}/profile`, formData, {
        reportProgress: true,
        responseType: 'json'
      });
      return this.http.request(req);
    }

}

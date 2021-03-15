import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable()
export class UnAuthService {

  baseUrl = environment.baseUrl + '/authenticate'

  constructor(private http :HttpClient) { }

  login(loginObj :any) :Observable<any>{
    return this.http.post(this.baseUrl, loginObj);
  }

  sendEmail(loginObj :any) :Observable<any>{
    return this.http.post(this.baseUrl + '/send-email', loginObj);
  }

  resetPassword(loginObj :any) :Observable<any>{
    return this.http.post(this.baseUrl + '/reset-password', loginObj);
  }
}

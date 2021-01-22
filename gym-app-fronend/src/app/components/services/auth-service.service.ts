import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http :HttpClient) { }

  login(loginObj :any) :Observable<any>{
    return this.http.post(environment.baseUrl + '/authenticate', loginObj);
  }
}

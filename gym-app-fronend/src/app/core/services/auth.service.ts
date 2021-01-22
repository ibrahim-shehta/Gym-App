import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppURL } from 'src/app/app.url';
import { environment } from 'src/environments/environment';
import { StorageKeys } from '../constants/StorageKeys';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http :HttpClient, private router :Router) { }

  login(loginObj :any) :Observable<any>{
    return this.http.post(environment.baseUrl + '/authenticate', loginObj);
  }

  isUserLogged() {
    return localStorage.getItem(StorageKeys.LOGGED_USER) ? true : false;
  }

  getLoggedUser() {
    return JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
  }

  logout() {
    localStorage.clear();
    this.router.navigate(["/", AppURL.Login]);
  }
}

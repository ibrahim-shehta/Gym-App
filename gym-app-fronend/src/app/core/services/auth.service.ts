import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppURL } from 'src/app/app.url';
import { environment } from 'src/environments/environment';
import { StorageKeys } from '../constants/StorageKeys';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = environment.baseUrl + '/authenticate'

  constructor(private http :HttpClient, private router :Router) { }

  isUserLogged() {
    return localStorage.getItem(StorageKeys.LOGGED_USER) ? true : false;
  }

  getLoggedUser() {
    return JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
  }

  logout() {
    localStorage.clear();
    this.router.navigate(["/",AppURL.UnAuth ,AppURL.Login]);
  }
}

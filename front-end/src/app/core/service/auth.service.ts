import { Injectable } from '@angular/core';
import { StorageKeys } from '../constants/StorageKeys';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }


  isUserLogged() {
    return localStorage.getItem(StorageKeys.LOGGED_USER) ? true : false;
  }

  getLoggedUser() {
    return JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
  }
}

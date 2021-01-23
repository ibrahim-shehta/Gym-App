import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from "rxjs";
import { finalize, delay, map, catchError } from "rxjs/operators";

import { StorageKeys } from '../constants/StorageKeys';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {
  constructor(private authService :AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Get token & add to request headers

    const isLoggin = request.url.indexOf('authenticate') > -1 ? true : false;
    if (isLoggin) {
      return next.handle(request);
    }

    const user = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER));
    const lang = localStorage.getItem(StorageKeys.APP_LANG);


    if (user) {
      request = request.clone({ headers: request.headers.set('Authorization', 'Bearer ' + user.data.token) });
    }

  if (!request.headers.has('Content-Type')) {
      request = request.clone({ headers: request.headers.set('Content-Type', 'application/json') });
    }

     request = request.clone({ headers: request.headers.set('Accept', 'application/json') });
     request = request.clone({ headers: request.headers.set('Accept-Language', lang ? lang : 'en') });

    return next.handle(request).pipe(
      catchError((err :HttpErrorResponse) => {
        console.log(err , '------------>')
        if (err.status === 401) {

          this.authService.logout();
          // // Refresh tokens
          // return this.authService.InitRefresh().pipe(
          //   switchMap((response) => {
          //     // Get new token
          //     token = this.authService.GetAccessToken();
          //     request = request.clone({
          //       headers: request.headers
          //         .set('Authorization', `Bearer ${token}`)
          //     });
          //     // Continue original request
          //     return next.handle(request);
          //   })
          // );
          return throwError(err);
        } else {
          return throwError(err);
        }
      }));
  }

  private handleAccess(request: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    const token = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).token;
    let changedRequest = request;
    debugger;
    // HttpHeader object immutable - copy values
    const headerSettings: {[name: string]: string | string[]; } = {};

    for (const key of request.headers.keys()) {
      headerSettings[key] = request.headers.getAll(key);
    }
    if (token) {
      headerSettings['Authorization'] = 'Bearer ' + token;
    }
    headerSettings['Content-Type'] = 'application/json';
    const newHeader = new HttpHeaders(headerSettings);

    changedRequest = request.clone({
      headers: newHeader});
    return next.handle(changedRequest);
  }

}

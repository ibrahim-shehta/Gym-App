import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { RoutingUrls } from '../constants/RoutingUrls';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuardService implements CanActivate {
  constructor(private authService: AuthService, private router:Router ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (this.authService.isUserLogged()) {
      return true;
    } else {
      this.router.navigate([RoutingUrls.AUTH + RoutingUrls.SLASH + RoutingUrls.LOGIN])
      return false;
    }
  }
}

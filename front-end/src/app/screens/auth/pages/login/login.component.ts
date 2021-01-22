import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { RoutingUrls } from 'src/app/core/constants/RoutingUrls';
import { StorageKeys } from 'src/app/core/constants/StorageKeys';
import { AuthService } from 'src/app/core/service/auth.service';
import { NotificationService } from 'src/app/core/service/notification.service';
import { AuthServiceService } from '../../services/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginObj : any = {};
  constructor(
    public translate: TranslateService,
    private authServiceService :AuthServiceService,
    private notificationService :NotificationService,
    private router :Router,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    if (this.authService.isUserLogged()) {
      this.router.navigate([RoutingUrls.SCREENS + RoutingUrls.SLASH + RoutingUrls.DASHBOARD]);
    }
  }

  login() {
    console.log(this.loginObj);
    this.authServiceService.login(this.loginObj).subscribe(res => {
      localStorage.setItem(StorageKeys.LOGGED_USER, JSON.stringify(res));
      this.router.navigate([RoutingUrls.SCREENS + RoutingUrls.SLASH + RoutingUrls.DASHBOARD]);
    }, err => this.notificationService.showError(this.translate.instant('USERS.LOGIN_SCREEN.LOGIN_VALIDATION'), this.translate.instant('COMMON.ERROR')))
  }

}

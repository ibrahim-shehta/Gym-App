import { Component, OnInit } from "@angular/core";
import { AppURL } from "src/app/app.url";
import { AuthURL } from "src/app/authentication/authentication.url";
import { Router } from "@angular/router";
import { Ng2IzitoastService } from "ng2-izitoast";
import { AccountService, IAccount } from "../../services/account.service";
import { AuthService } from "src/app/core/services/auth.service";
import { NotificationService } from "src/app/core/services/notification.service";
import { TranslateService } from "@ngx-translate/core";
import { StorageKeys } from "src/app/core/constants/StorageKeys";
import { environment } from "src/environments/environment";

@Component({
  selector: "app-auth-navbar",
  templateUrl: "./auth-navbar.component.html",
  styleUrls: ["./auth-navbar.component.css"],
})
export class AuthNavbarComponent implements OnInit {
  AppURL = AppURL;
  AuthURL = AuthURL;
  UserLogin;
user;
userImg;
  constructor(
    private router: Router,
    private notificationService: NotificationService,
    private authService: AuthService,
    public translate : TranslateService
  ) {}

  ngOnInit() {
    this.initUser();
    this.user = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
    this.userImg = environment.baseImagesUrl + '/profile/' + this.user.imageName;

  }

  initUser() {
    this.UserLogin = this.authService.getLoggedUser();
  }

  onLogout() {
    this.authService.logout();
    this.notificationService.showSuccess(this.translate.instant('AUTH_NAVBAR.LOGOUT_SUCCESS'), '');
  }

  changeLang(lang) {
    localStorage.setItem(StorageKeys.APP_LANG, lang);
    window.location.reload()
  }
}

import { Component, OnInit } from "@angular/core";
import { AppURL } from "src/app/app.url";
import { AuthURL } from "src/app/authentication/authentication.url";
import { Router } from "@angular/router";
import { AuthService } from "src/app/core/services/auth.service";
import { NotificationService } from "src/app/core/services/notification.service";
import { TranslateService } from "@ngx-translate/core";
import { StorageKeys } from "src/app/core/constants/StorageKeys";

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
    public translate : TranslateService,
   // private appStateService :AppStateService
  ) {}

  ngOnInit() {
    this.initUser();
    // this.getProfileImage();
  }

  // getProfileImage() {
  //   this.appStateService.profileImage.subscribe(res => {
  //     this.userImg = res ? environment.baseImagesUrl + '/profile/' +res : null;
  //   })
  // }


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

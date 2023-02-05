import { Component, OnInit, HostListener,Inject, } from "@angular/core";
import { AppURL } from "src/app/app.url";
import { AuthURL } from "src/app/authentication/authentication.url";
import { Router } from "@angular/router";
import { AuthService } from "src/app/core/services/auth.service";
import { NotificationService } from "src/app/core/services/notification.service";
import { TranslateService } from "@ngx-translate/core";
import { StorageKeys } from "src/app/core/constants/StorageKeys";


import { DOCUMENT } from '@angular/common';

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


elem: any;
  isFullScreen: boolean;


  constructor(
    private router: Router,
    private notificationService: NotificationService,
    private authService: AuthService,
    public translate : TranslateService,
   // private appStateService :AppStateService

   @Inject(DOCUMENT) private document: any
  ) {}

  ngOnInit() {
    this.initUser();
    // this.getProfileImage();


    // this.chkScreenMode();
    // this.elem = document.documentElement;
    // setTimeout(() => this.openFullscreen(), 0);
  }

  @HostListener('document:fullscreenchange', ['$event'])
  @HostListener('document:webkitfullscreenchange', ['$event'])
  @HostListener('document:mozfullscreenchange', ['$event'])
  @HostListener('document:MSFullscreenChange', ['$event'])
  fullscreenmodes(event) {
    this.chkScreenMode();
  }
  chkScreenMode() {
    if (document.fullscreenElement) {
      //fullscreen
      this.isFullScreen = true;
    } else {
      //not in full screen
      this.isFullScreen = false;
    }
  }
  openFullscreen() {
    if (this.elem.requestFullscreen) {
      this.elem.requestFullscreen();
    } else if (this.elem.mozRequestFullScreen) {
      /* Firefox */
      this.elem.mozRequestFullScreen();
    } else if (this.elem.webkitRequestFullscreen) {
      /* Chrome, Safari and Opera */
      this.elem.webkitRequestFullscreen();
    } else if (this.elem.msRequestFullscreen) {
      /* IE/Edge */
      this.elem.msRequestFullscreen();
    }
  }
  /* Close fullscreen */
  closeFullscreen() {
    if (this.document.exitFullscreen) {
      this.document.exitFullscreen();
    } else if (this.document.mozCancelFullScreen) {
      /* Firefox */
      this.document.mozCancelFullScreen();
    } else if (this.document.webkitExitFullscreen) {
      /* Chrome, Safari and Opera */
      this.document.webkitExitFullscreen();
    } else if (this.document.msExitFullscreen) {
      /* IE/Edge */
      this.document.msExitFullscreen();
    }
  }



















  // ==============
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

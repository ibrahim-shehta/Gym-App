import { Component, OnInit } from '@angular/core';
import { AppURL } from 'src/app/app.url';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AccountService, IAccount } from '../../services/account.service';
import { Router } from '@angular/router';
import { Ng2IzitoastService } from 'ng2-izitoast';
import { AuthenService } from 'src/app/core/services/authen.service';
import { environment } from 'src/environments/environment';
import { AppStateService } from 'src/app/core/services/app-state.service';

@Component({
  selector: 'app-auth-sidebar',
  templateUrl: './auth-sidebar.component.html',
  styleUrls: ['./auth-sidebar.component.css']
})
export class AuthSidebarComponent implements OnInit {

  userImg;
  permissions :any = {};
  Object = Object;

  constructor(
    private account:AccountService,
    private authen:AuthenService,
    private router:Router,
    private iziToast: Ng2IzitoastService ,
    private appStateService: AppStateService
  ) {
    //this.initialloadUserLogin();
  }
  AppURL = AppURL;
  AuthURL = AuthURL;
  UserLogin : IAccount;
  ngOnInit() {
    this.getProfileImage();
    this.permissions = this.appStateService.permissions;
  }

  getProfileImage() {
    this.appStateService.profileImage.subscribe(res => {
      this.userImg = res ? environment.baseFilesesUrl + '/profile/' +res : null;
    })
  }

  private initialloadUserLogin(){
      this.account
          .getUserLogin(this.authen.getAuthenticated())
          .then(userLogin => this.UserLogin = userLogin)
          .catch(err => {
            this.iziToast.warning({
              title: 'แจ้งเตือน',
              message: err.Message,
              position: 'topRight'
            });
            this.authen.clearAuthenticated();
            this.router.navigate(['/',AppURL.UnAuth,  AppURL.Login])
          })
  }


  getModulesKeys() : string[] {
    return Object.keys(this.permissions);;
  }

  getScrensKeys(key: string) :string[] {
    return Object.keys(this.permissions[key]['children']);
  }

}

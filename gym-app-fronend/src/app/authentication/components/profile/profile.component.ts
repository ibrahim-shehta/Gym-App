import { Component, OnInit } from '@angular/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from 'src/app/core/services/notification.service';
import { TranslateService } from '@ngx-translate/core';
import {UserService} from './users.service';
import { StorageKeys } from 'src/app/core/constants/StorageKeys';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AppStateService } from 'src/app/core/services/app-state.service';
import { MemberService } from '../../modules/subscriptions-module/pages/members/services/member.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent extends BaseFormCompnent<any> implements OnInit{
  user: any;
  image;
  progress;
  message;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService,
    private memberService: MemberService,
    private appStateService :AppStateService

  ) {
    super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
    this.image = environment.baseFilesesUrl + '/profile/' + this.user.imageName;
  }


  onSaveSelectedFileHandler(e) {
    this.memberService.uploadUserProfileImage(e).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.message = this.translateService.instant('COMMON.UPLOAD_SUCCESS');
        this.appStateService.changeProfileImage(event.body.data.imageName);
        setTimeout(() => {
          this.progress = 0;
          this.message = null;
        }, 1000);

        const logedUserData = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER));
        logedUserData.data.user = event.body.data;
        localStorage.setItem(StorageKeys.LOGGED_USER, JSON.stringify(logedUserData));
      }
    },
    err => {
      this.progress = 0;
      this.backendError(err.error);
      this.message = this.translateService.instant('COMMON.UPLOAD_FAIL');
    })
  }


  // onConvertImage(input: HTMLInputElement, form: NgForm) {
  //   const imageControl = input.value;
  //   const imageTypes = ['image/jpeg', 'image/png'];
  //   imageControl.setValue(null);
  //   if (input.files.length == 0) return;
  //   if (imageTypes.indexOf(input.files[0].type) < 0) {
  //     input.value = null;
  //     this.image = null;
  //     return;
  //   }
  //   this.image = imageControl;
  //   const reader = new FileReader;
  //   reader.readAsDataURL(input.files[0]);
  //   reader.addEventListener('load', () => {
  //     imageControl.setValue(reader.result);
  //   })
  // }


  getService() :UserService {
    return null//this.userService;
  }
}

import { Component, OnInit } from '@angular/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from 'src/app/core/services/notification.service';
import { TranslateService } from '@ngx-translate/core';
import {UserService} from './users.service';
import { StorageKeys } from 'src/app/core/constants/StorageKeys';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { PlayersService } from '../../pages/users/services/players.service';
import { AppStateService } from 'src/app/core/services/app-state.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent extends BaseFormCompnent implements OnInit{
  user: any;
  image;
  imageFile :File;
  progress;
  message;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService,
    private playersService: PlayersService,
    private appStateService :AppStateService

  ) {
    super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER)).data.user;
    this.image = environment.baseImagesUrl + '/profile/' + this.user.imageName;
  }

  uploadImage() {
    this.playersService.uploadUserProfileImage(this.imageFile).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        console.log(event);
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.message = 'file uploaded successfuly';
        this.appStateService.changeProfileImage(event.body.data.imageName);
        setTimeout(() => {
          this.progress = 0;
          this.message = null;
        }, 1000);

        const logedUserData = JSON.parse(localStorage.getItem(StorageKeys.LOGGED_USER));
        logedUserData.data.user = event.body.data;
        localStorage.setItem(StorageKeys.LOGGED_USER, JSON.stringify(logedUserData));
        console.log(event);
      }
    },
    err => {
      this.progress = 0;
      this.backendError(err.error);
      this.message = 'Could not upload the file:' + this.imageFile.name;
    })
  }


  isFileSelected = false;
  onFileChanged(event) {
    this.imageFile = event.target.files[0];
    const reader = new FileReader;
    reader.readAsDataURL(this.imageFile);
    this.isFileSelected = true;
    reader.onload = (event :any) => {
      this.image = event.target.result;
    }
    // reader.addEventListener('load', () => {
    //   this.image = reader.result;
    // })
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

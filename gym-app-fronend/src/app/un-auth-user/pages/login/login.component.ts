import { Component, OnInit } from '@angular/core';
import { AppURL } from '../../../app.url';
import { ILoginComponent } from './login.interface';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NotificationService } from 'src/app/core/services/notification.service';
import { TranslateService } from '@ngx-translate/core';
import { StorageKeys } from 'src/app/core/constants/StorageKeys';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthService } from 'src/app/core/services/auth.service';
import { UnAuthService } from '../../services/un-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements ILoginComponent, OnInit{

  showResetPassword :boolean = false;
  Url = AppURL;
  form: FormGroup;

  constructor(
    private builder: FormBuilder,
    private notificationService: NotificationService ,
    private router: Router,
    private authService: AuthService,
    private unAuthService : UnAuthService,
    public translate :TranslateService
  ) {}

  ngOnInit() {
    if (this.authService.isUserLogged()) {
      this.router.navigate(['/' , AppURL.Authen , AuthURL.Dashboard]);
      return;
    }
    this.initialCreateFormData();
    this.initResetPasswordForm();
  }

  onSubmit() {
    if (this.form.invalid) {
       this.notificationService.showError(this.translate.instant('COMMON.ERROR'), this.translate.instant('USERS.LOGIN_SCREEN.LOGIN_VALIDATION'));
       return;
    }

    this.unAuthService.login({username: this.form.value.email, password: this.form.value.password}).subscribe(res => {
      localStorage.setItem(StorageKeys.LOGGED_USER, JSON.stringify(res));
      this.notificationService.showSuccess(this.translate.instant('AUTH_NAVBAR.LOGIN_SUCCESS'), '');
      this.router.navigate(['/' , AppURL.Authen , AuthURL.Dashboard]);

    }, err => {
      this.notificationService.showError(this.translate.instant('COMMON.ERROR'), this.translate.instant('USERS.LOGIN_SCREEN.LOGIN_VALIDATION'));
    })

  }

  private initialCreateFormData() {
    this.form = this.builder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      remember: [true]
    });
  }

  resetForm :FormGroup;
  private initResetPasswordForm() {
    this.resetForm = this.builder.group({
      email: ['', [Validators.required, Validators.email]],
    });
  }


  sendMailToResetPassword() {
    if (this.resetForm.invalid) {
      this.notificationService.showError(this.translate.instant('COMMON.VALIDATION_ERROR'), '');
      return;
    }

    this.unAuthService.sendEmail({email: this.resetForm.value.email}).subscribe(res => {
      this.notificationService.showSuccess(this.translate.instant('RESET_PASSWORD.SEND_SUCCESS'), '');
      this.showResetPassword = false;
    }, err => {
        this.notificationService.showError(err.error.message, '');
    })
  }

}

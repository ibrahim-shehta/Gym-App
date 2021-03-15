import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AppURL } from 'src/app/app.url';
import { NotificationService } from 'src/app/core/services/notification.service';
import { UnAuthService } from '../../services/un-auth.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  password :string;
  repassword :string;
  code :string;
  constructor(
    private notificationService: NotificationService ,
    private router: Router,
    private unAuthService: UnAuthService,
    public translate :TranslateService,
    private activatedRoute :ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.code = this.activatedRoute.snapshot.queryParams["code"];
    if (!this.code) {
      this.router.navigate(['/', AppURL.UnAuth]);
    }
  }

  onSubmit(form: NgForm) {
    if (form.invalid || this.password !== this.repassword) {
      this.notificationService.showError(this.translate.instant('COMMON.VALIDATION_ERROR'), '');
      return;
    }
    if (this.password === this.repassword) {
      this.unAuthService.resetPassword({password: this.password, code: this.code}).subscribe(res => {
        this.notificationService.showSuccess(this.translate.instant('RESET_PASSWORD.CHANGE_SUCCESS'), '');
            this.router.navigate(['/', AppURL.UnAuth]);
      }, err => {
          this.notificationService.showError(err.error.message, '');
      });
    }
  }

}

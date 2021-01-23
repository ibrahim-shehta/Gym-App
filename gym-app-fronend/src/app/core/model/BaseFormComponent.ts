import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { ResponseStatus } from "../constants/response-status-enum";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";

export class BaseFormCompnent extends BaseComponent {

  entity :any = {};
  id :number;
  isEditMode :boolean;

  constructor(
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {
        super(notificationService, translateService);
  }

  modeInit() {
    if (this.activatedRoute.snapshot.data.entity) {
      this.isEditMode = true;
      this.entity = this.activatedRoute.snapshot.data.entity.data;
    }
  }

  validForm(form :NgForm) {
    if (form.invalid)
      this.notificationService.showError('', this.translateService.instant('COMMON.VALIDATION_ERROR'));
    return form.invalid;
  }

  save(enity :any) {
    if (this.isEditMode) {
      this.edit(enity);
    } else {
      this.add(enity);
    }

  }

  add(entity :any, reset? :any[]) {}
  edit(entity :any, reset? :any[]) {}

  goBack() {
    this.router.navigate(['../'], {relativeTo: this.activatedRoute});
  }

  addSuccess() {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.SAVE_SUCCESS'));
  }

  eidtSuccess() {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.EDIT_SUCCESS'));
  }

}

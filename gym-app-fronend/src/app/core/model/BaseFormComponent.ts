import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { ResponseStatus } from "../constants/response-status-enum";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";

export abstract class BaseFormCompnent extends BaseComponent {

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

  modeInit() :void {
    if (this.activatedRoute.snapshot.data.entity) {
      this.isEditMode = true;
      this.entity = this.activatedRoute.snapshot.data.entity.data;
    }
  }

  validForm(form :NgForm) :boolean {
    if (form.invalid)
      this.notificationService.showError('', this.translateService.instant('COMMON.VALIDATION_ERROR'));
    return form.invalid;
  }

  save(enity :any) :void {
    if (this.isEditMode) {
      this.edit(enity);
    } else {
      this.add(enity);
    }

  }

  abstract add(entity :any, reset? :any[]) :void ;
  abstract edit(entity :any, reset? :any[]) :void ;

  goBack() :void {
    this.router.navigate(['../'], {relativeTo: this.activatedRoute});
  }

  addSuccess() :void {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.SAVE_SUCCESS'));
  }

  eidtSuccess() :void {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.EDIT_SUCCESS'));
  }

}

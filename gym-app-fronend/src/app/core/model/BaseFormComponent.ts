import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { NotificationService } from "../services/notification.service";
import { BaseComponent } from "./BaseComponent";
import { BaseEntity } from "./BaseEntity";

export abstract class BaseFormCompnent<T extends BaseEntity> extends BaseComponent {

  entity :T;
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
    if (this.activatedRoute.snapshot.data.form) {
      this.getResolverData();
    }
  }

  getResolverData() {
    this.entity = this.activatedRoute.snapshot.data.form.data;
    this.isEditMode = true;
  }

  onSubmit(form :NgForm) :void {
    if (this.validForm(form)) {
      return;
    }
    console.log(form.value)
    this.save(this.entity);
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

  add(entity) :void {
    this.getService().add(entity).subscribe(res => {
      this.addSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }

  edit(entity) :void {
    this.getService().edit(entity).subscribe(res => {
      this.eidtSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }

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

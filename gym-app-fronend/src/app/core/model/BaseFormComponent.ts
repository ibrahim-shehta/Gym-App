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

  initFormMode() :void {
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
    this.save(this.entity);
  }

  validForm(form :NgForm) :boolean {
    if (form.invalid)
      this.notificationService.showError('', this.translateService.instant('COMMON.VALIDATION_ERROR'));
    return form.invalid;
  }

  save(enity :any) :void {
    if (this.isEditMode)
      this.update(enity);
    else
      this.insert(enity);

  }

  insert(entity) :void {
    this.getService().insert(entity).subscribe(res => {
      this.entity.id = res.data.id;
      this.afterInsertSuccess();
    }, err => {
      this.backendError(err.error);
    })
  }

  afterInsertSuccess() {
    this.showInsertSuccessMessageAndBack();
  }

  showInsertSuccessMessageAndBack() {
    this.insertSuccessMsg();
    this.goBack();
  }


  insertSuccessMsg() :void {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.SAVE_SUCCESS'));
  }

  update(entity) :void {
    this.getService().update(entity).subscribe(res => {
      this.afterUpdateSuccess();
    }, err => {
      this.backendError(err.error);
    })
  }

  afterUpdateSuccess() {
      this.showUpdatetSuccessMessageAndBack();
  }

  showUpdatetSuccessMessageAndBack() {
    this.updateSuccessMsg();
    this.goBack();
  }

  updateSuccessMsg() :void {
    this.notificationService.showSuccess('', this.translateService.instant('COMMON.EDIT_SUCCESS'));
  }

  goBack() :void {
    this.router.navigate(['../'], {relativeTo: this.activatedRoute});
  }

}

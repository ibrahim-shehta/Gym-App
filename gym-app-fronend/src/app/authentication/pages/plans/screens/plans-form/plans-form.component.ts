import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlansService } from '../../services/plans.service';

@Component({
  selector: 'app-plans-form',
  templateUrl: './plans-form.component.html',
  styleUrls: ['./plans-form.component.scss']
})
export class PlansFormComponent extends BaseFormCompnent implements OnInit {



  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private plansService :PlansService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() {
    this.modeInit();
    if (this.isEditMode) {
      this.prepareEditPlan(this.entity);
    }
  }

  onSubmit(form :NgForm) {
    if (this.validForm(form)) {
      return;
    }
    const entity = this.preparePlan(this.entity);

   this.save(entity);
  }

  add(plan) {
    this.plansService.addPlan(plan).subscribe(res => {
      this.addSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }

  edit(plan) {
    this.plansService.editPlan(plan).subscribe(res => {
      this.eidtSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }

  private preparePlan(fomrVal) {
    return {
      id: fomrVal.id,
      price: fomrVal.price,
      numberOfDays: fomrVal.numberOfDays ,
      numberOfReservedDays: fomrVal.numberOfReservedDays,
      numberOfInvitations: fomrVal.numberOfInvitations,
      discount: fomrVal.discount,
      isSpecial: fomrVal.isSpecial,
      planTranslate: [
        {
          id: fomrVal.idAr,
          langCode: 'ar',
          name: fomrVal.nameAr,
          description: fomrVal.descriptionAr
        },
        {
          id: fomrVal.idEn,
          langCode: 'en',
          name: fomrVal.nameEn,
          description: fomrVal.descriptionEn
        }
      ]
    }

  }

  prepareEditPlan(data) {
    const ar = data.planTranslate.find(i => i.langCode == 'ar');
    const en = data.planTranslate.find(i => i.langCode == 'en');
    this.entity = {
      id: data.id,
      price: data.price,
      numberOfDays: data.numberOfDays ,
      numberOfReservedDays: data.numberOfReservedDays,
      numberOfInvitations: data.numberOfInvitations,
      discount: data.discount,
      isSpecial: data.isSpecial,
      nameAr: ar.name,
      descriptionAr: ar.description,
      idAr: ar.id,
      nameEn: en.name,
      descriptionEn: en.description,
      idEn: en.id
    }
  }

}

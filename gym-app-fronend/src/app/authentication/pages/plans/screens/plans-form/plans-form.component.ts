import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
    private notificationService :NotificationService,
    private plansService :PlansService,
    private router :Router,
    private activatedRoute :ActivatedRoute
  ) {
        super();
  }

  ngOnInit() {
    if (this.activatedRoute.snapshot.data.plan) {
      this.isEditMode = true;
      const data = this.activatedRoute.snapshot.data.plan.data;
      this.prepareEditPlan(data);
      console.log(data);
    }
  }

  onSubmit(form :NgForm) {
    if (form.invalid) {
      this.notificationService.showError('error', 'validation error');
      return;
    }

    console.log(form.value);
    const val = this.preparePlan(this.entity);
    console.log(val);

    if (this.isEditMode) {
      this.edit(val);
    } else {
      this.add(val);
    }

  }

  add(plan) {
    this.plansService.addPlan(plan).subscribe(res => {
      this.notificationService.showSuccess('save', 'save done');
      this.goBack();
    }, err => {
      this.notificationService.showError('backedn error', err.message);
    })
  }

  edit(plan) {
    this.plansService.editPlan(plan).subscribe(res => {
      this.notificationService.showSuccess('save', 'save done');
      this.goBack();
    }, err => {
      this.notificationService.showError('backedn error', err.message);
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

  goBack() {
    this.router.navigate(['../'], {relativeTo: this.activatedRoute});
  }

}

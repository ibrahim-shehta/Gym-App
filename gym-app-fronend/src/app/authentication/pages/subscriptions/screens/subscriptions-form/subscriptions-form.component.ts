import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import {  FilterMap } from 'src/app/core/model/FilterDataWithPaginationAndSort';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlayersService } from '../../../users/services/players.service';
import { SubscriptionsService } from '../../services/subscriptions.service';

@Component({
  selector: 'app-subscriptions-form',
  templateUrl: './subscriptions-form.component.html',
  styleUrls: ['./subscriptions-form.component.scss']
})
export class SubscriptionsFormComponent extends BaseFormCompnent implements OnInit {

  plans :any[] = [];
  selectedPlan :any;
  list = [];
  userSearch = '';
  usersList :any[] = [];
  selectedUser :any;

  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private subscriptionsService :SubscriptionsService,
    private playersService :PlayersService
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() :void {
    this.modeInit();
    if (this.isEditMode) {
      //this.prepareEditPlan(this.entity);
    }
    console.log(this.entity)
  }

  getResolverData() {
    //this.entity = this.activatedRoute.snapshot.data.entity.data;
    this.plans = this.activatedRoute.snapshot.data.form.plans.data;
    if (!this.activatedRoute.snapshot.data.form.entity) {
      this.isEditMode = false;
    }
    console.log(this.activatedRoute.snapshot.data.entity);
  }

  findUser() {
    const filterMap: FilterMap = new  FilterMap();
    filterMap.filterMap = {
      "mobile":this.userSearch,
      "username":this.userSearch,
      "email":this.userSearch
    }

    this.playersService.filterAllData(filterMap).subscribe(res => {
      console.log(res);
      this.usersList = res.data;
      this.selectedUser = res.data[0];
      this.entity.user =  res.data[0].id
      console.log(this.entity);
    }, err => this.backendError(err.error))
  }

  onChange(id) {
    console.log(this.entity);
    if (id == 0) {
      this.entity.plan = null;
      console.log(this.entity);
      return;
    }
    this.selectedPlan = this.plans.find(plan => plan.id == id);
  }

  onChangeUser(id) {
    console.log(this.entity);
    if (id == 0) {
      this.entity.user = null;
      console.log(this.entity);
      return;
    }
    this.selectedUser = this.usersList.find(user => user.id == id);
  }

  onSubmit(form :NgForm) :void {
    console.log(form.value);
    if (this.validForm(form)) {
      return;
    }
    this.entity.user = {
      id: this.entity.user
    }
    this.entity.plan = {
      id: this.entity.plan
    }
   this.save(this.entity);
  }

  add(plan) :void {
    this.subscriptionsService.add(plan).subscribe(res => {
      this.addSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }

  edit(plan) :void {
    this.subscriptionsService.edit(plan).subscribe(res => {
      this.eidtSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
    })
  }
}

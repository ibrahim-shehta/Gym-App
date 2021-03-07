import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
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
  showPlayerDetails :boolean = false;
  plans :any[] = [];
  selectedPlan :any;
  list = [];
  userSearch = '';
  usersList :any[] = [];
  selectedUser :any;
  netPrice = 0;

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
    if (!this.isEditMode) {
      this.entity = {user: {}, plan: {}}
    }
  }

  getResolverData() {
    this.plans = this.activatedRoute.snapshot.data.form.plans.data;
    if (!this.activatedRoute.snapshot.data.form.entity) {
      this.isEditMode = false;
    }
  }

  findUser() {
    const filterMap: FilterMap = new  FilterMap();
    filterMap['mobile'] = this.userSearch
    filterMap['username'] = this.userSearch
    filterMap['email'] = this.userSearch

    this.playersService.filterAllData(filterMap).subscribe(res => {
      this.usersList = res.data;
      this.selectedUser = res.data[0];
      this.entity.user.id =  res.data[0].id
    }, err => this.backendError(err.error))
  }

  onChangePlan(id) {
    if (id == 0) {
      this.entity.plan.id = null;
      this.selectedPlan = null;
      return;
    }
    this.selectedPlan = this.plans.find(plan => plan.id == id);
    this.netPrice = Math.ceil(this.selectedPlan.price - (this.selectedPlan.price *this.selectedPlan.discount / 100));
  }

  onChangeUser(id) {
    if (id == 0) {
      this.entity.user.id = null;
      this.selectedUser = null;
      return;
    }
    this.selectedUser = this.usersList.find(user => user.id == id);
  }

  getService() :SubscriptionsService {
    return this.subscriptionsService;
  }

}

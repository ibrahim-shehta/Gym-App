import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { CategoriesService } from 'src/app/authentication/modules/exercises-module/pages/categories/categories/services/categories-service';
import { SubscriptionsService } from 'src/app/authentication/modules/subscriptions-module/pages/subscriptions/subscriptions/services/subscriptions.service';

@Injectable()
export class PlayersAttendanceService implements Resolve<any> {


  constructor(
    private router :Router,
    private categoriesService :CategoriesService,
    private _location: Location,
    private subscriptionsService :SubscriptionsService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (!this.router.getCurrentNavigation().extras.state) {
        this._location.back();
      } else
        //return this.categoriesService.getAll()

        return forkJoin({
          categories: this.categoriesService.getAll(),
          subscription: this.subscriptionsService.getInProgressSubscription(this.router.getCurrentNavigation().extras.state.id)
        })
     }


  }

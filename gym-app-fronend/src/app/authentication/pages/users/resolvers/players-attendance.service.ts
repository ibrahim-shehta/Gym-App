import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { CategoriesService } from '../../exercises/categories/services/categories-service';
import { SubscriptionsService } from '../../subscriptions/services/subscriptions.service';

@Injectable({
  providedIn: 'root'
})
export class PlayersAttendanceService implements Resolve<any> {


  constructor(
    private router :Router,
    private categoriesService :CategoriesService,
    private _location: Location,
    private subscriptionsService :SubscriptionsService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

      forkJoin({

      })
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

import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';

import { SubscriptionsService } from '../services/subscriptions.service';
import { map, filter } from "rxjs/operators";
import { PlansService } from 'src/app/authentication/modules/subscriptions-module/pages/plans/services/plans.service';

@Injectable()
export class SubscriptionsFormResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private subscriptionsService :SubscriptionsService,
    private plansService :PlansService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

      const arr = [
        this.plansService.getAll()
      ]
     let id;
     if (this.router.getCurrentNavigation().extras.state)
       id = this.router.getCurrentNavigation().extras.state.id;

      if (id) {
        arr.push(this.subscriptionsService.getById(id));
      }

      return forkJoin(arr).pipe(
        map((result) => {
          return {
            plans: result[0],
            enity: id ? result[1]: null
          };
        })
      )


    }
}

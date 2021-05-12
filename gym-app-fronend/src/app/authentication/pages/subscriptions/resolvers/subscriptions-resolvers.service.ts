import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { SubscriptionsService } from '../services/subscriptions.service';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsResolversService  implements Resolve<any>  {


  constructor(
    private subscriptionsService :SubscriptionsService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return forkJoin([
        this.subscriptionsService.getStatusList(),
        this.subscriptionsService.filterWithPagination()
      ]);
      //return this.subscriptionsService.filterWithPagination();
    }


}

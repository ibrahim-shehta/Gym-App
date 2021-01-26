import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { SubscriptionsService } from '../services/subscriptions.service';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsResolversService  implements Resolve<any>  {


  constructor(
    private subscriptionsService :SubscriptionsService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return this.subscriptionsService.filterWithPagination();
    }


}

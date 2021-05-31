import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { lookupTypeCode } from 'src/app/core/constants/lookup-type-code.enum';
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
        this.subscriptionsService.getStatusList(lookupTypeCode.SUBSCRIPTION_STATUS),
        this.subscriptionsService.filterWithPagination()
      ]);
      //return this.subscriptionsService.filterWithPagination();
    }


}

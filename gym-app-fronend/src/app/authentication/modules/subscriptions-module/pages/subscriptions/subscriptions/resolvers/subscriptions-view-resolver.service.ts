import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { SubscriptionsService } from '../services/subscriptions.service';

@Injectable()
export class SubscriptionsViewResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private subscriptionsService :SubscriptionsService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      let id;
      if (this.router.getCurrentNavigation().extras.state)
        id = this.router.getCurrentNavigation().extras.state.id;
        if (!id) {
          return;
        }
      return this.subscriptionsService.getById(id);
    }
}

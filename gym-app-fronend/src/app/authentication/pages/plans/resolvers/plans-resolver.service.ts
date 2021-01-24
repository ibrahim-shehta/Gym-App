import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { PlansService } from '../services/plans.service';

@Injectable({
  providedIn: 'root'
})
export class PlansResolverService implements Resolve<any> {

constructor(
  private plansService :PlansService
) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.plansService.filterWithPagination();
  }


}

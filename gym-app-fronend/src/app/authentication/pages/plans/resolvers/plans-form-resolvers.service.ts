import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { PlansService } from '../services/plans.service';

@Injectable({
  providedIn: 'root'
})
export class PlansFormResolversService {

  constructor(
    private router :Router,
    private plansService :PlansService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
     let id;
     if (this.router.getCurrentNavigation().extras.state)
       id = this.router.getCurrentNavigation().extras.state.id;

      if (id) {
         return this.plansService.getById(id);
      } else {
          return null;
      }
    }

}

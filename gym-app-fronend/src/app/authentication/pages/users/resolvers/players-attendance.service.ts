import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { CategoriesService } from '../../exercises/categories/services/categories-service';

@Injectable({
  providedIn: 'root'
})
export class PlayersAttendanceService implements Resolve<any> {


  constructor(
    private router :Router,
    private categoriesService :CategoriesService,
    private _location: Location
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

      if (!this.router.getCurrentNavigation().extras.state) {
        this._location.back();
      } else
        return this.categoriesService.getAll()

     }
  }

import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { CategoriesService } from '../services/categories-service';

@Injectable({
  providedIn: 'root'
})
export class CategoriesResolverService implements Resolve<any> {

constructor(
  private categoriesService :CategoriesService
){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.categoriesService.filterWithPagination();
  }


}

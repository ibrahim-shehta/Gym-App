import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { CategoriesService } from '../services/categories-service';
import { forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable()
export class CategoriesFormResolversService implements Resolve<any> {

  constructor(
    private router: Router,
    private categoriesService: CategoriesService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

     let id;
     if (this.router.getCurrentNavigation().extras.state) {
       id = this.router.getCurrentNavigation().extras.state.id;
     }

     const arr: any = [
        this.categoriesService.getAll()
      ];

     if (id) {
        arr.push(this.categoriesService.getById(id));
      }

     return forkJoin(arr).pipe(
        map((result) => {
          return {
            categories: result[0],
            entity: id ? result[1] : null
          };
        })
      );
    }
}

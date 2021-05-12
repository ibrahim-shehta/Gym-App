import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';
import { EquipmentService } from '../../../equipment/services/equipment-service';
import { CategoriesService } from '../../categories/services/categories-service';
import { ExerciseService } from '../services/exercise-service';
@Injectable({
  providedIn: 'root'
})
export class ExerciseFormResolversService implements Resolve<any> {

  constructor(
    private router: Router,
    private exerciseService: ExerciseService,
    private equipmentService: EquipmentService,
    private categoriesService: CategoriesService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

     let id;
     if (this.router.getCurrentNavigation().extras.state) {
       id = this.router.getCurrentNavigation().extras.state.id;
     }

     const arr: any = [
        this.categoriesService.getAll(),
        this.equipmentService.getAll()
      ];

     if (id) {
        arr.push(this.exerciseService.getById(id));
      }

     return forkJoin(arr).pipe(
        map((result) => {
          return {
            categories: result[0],
            equipments: result[1],
            entity: id ? result[2] : null
          };
        })
      );
    }
}

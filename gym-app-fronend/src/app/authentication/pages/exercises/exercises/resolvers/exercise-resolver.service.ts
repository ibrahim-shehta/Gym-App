import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { ExerciseService } from '../services/exercise-service';

@Injectable({
  providedIn: 'root'
})
export class ExerciseResolverService implements Resolve<any> {

constructor(
  private exerciseService: ExerciseService
  ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.exerciseService.filterWithPagination();
  }


}

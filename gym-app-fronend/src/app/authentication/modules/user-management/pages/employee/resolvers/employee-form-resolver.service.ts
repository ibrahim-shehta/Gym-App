import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { forkJoin } from 'rxjs';
import { RolesService } from '../../roles/service/roles.service';
import { EmployeeService } from '../services/employee.service';
import { map } from 'rxjs/operators';

@Injectable()
export class EmployeeFormResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private employeeService :EmployeeService,
    private rolesService: RolesService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      let id;
      if (this.router.getCurrentNavigation().extras.state) {
        id = this.router.getCurrentNavigation().extras.state.id;
      }

  const arr: any = [
     this.rolesService.getAll()
   ];

  if (id) {
     arr.push(this.employeeService.getById(id));
   }

  return forkJoin(arr).pipe(
     map((result) => {
       return {
         roles: result[0],
         entity: id ? result[1] : null
       };
     })
   );
    }

}

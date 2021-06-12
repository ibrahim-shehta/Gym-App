import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { EmployeeService } from '../services/employee.service';

@Injectable()
export class EmployeeResolversService {


  constructor(
    private employeeService :EmployeeService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return this.employeeService.filterWithPagination();
    }


}

import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { lookupTypeCode } from 'src/app/core/constants/lookup-type-code.enum';
import { EmployeeService } from '../services/employee.service';
import { forkJoin } from 'rxjs';

@Injectable()
export class EmployeeResolversService {


  constructor(
    private employeeService :EmployeeService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return forkJoin([
        this.employeeService.getStatusList(lookupTypeCode.USER_STATUS),
        this.employeeService.filterWithPagination()
      ]);
    }


}

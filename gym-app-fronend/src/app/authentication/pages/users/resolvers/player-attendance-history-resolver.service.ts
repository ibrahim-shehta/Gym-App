import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { AttendanceService } from '../services/attendance.service';

@Injectable({
  providedIn: 'root'
})
export class PlayerAttendanceHistoryResolverService implements Resolve<any> {


  constructor(
    private router :Router,
    private _componentService :AttendanceService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (this.router.getCurrentNavigation().extras.state) {
        this._componentService.filterDataWithPaginationAndSort.filterMap = {userId: this.router.getCurrentNavigation().extras.state.id}
        return this._componentService.filterWithPagination();
      }
    }

}

import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { RolesService } from '../service/roles.service';

@Injectable()
export class RolesResolverService  implements Resolve<any>  {

  constructor(
    private rolesService: RolesService
  ) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.rolesService.filterWithPagination();
  }
}

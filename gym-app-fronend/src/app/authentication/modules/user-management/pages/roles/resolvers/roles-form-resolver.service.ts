import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { RolesService } from '../service/roles.service';
import { PermissionService } from '../service/permission.service';
import { forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class RolesFormResolverService implements Resolve<any> {

  constructor(
    private rolesService: RolesService,
    private permissionService: PermissionService,
    private router :Router
    ) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    let id;
    if (this.router.getCurrentNavigation().extras.state) {
      id = this.router.getCurrentNavigation().extras.state.id;
    }

const arr: any = [
   this.permissionService.getAll()
 ];

if (id) {
   arr.push(this.rolesService.getById(id));
 }

return forkJoin(arr).pipe(
   map((result) => {
     return {
       permissions: result[0],
       entity: id ? result[1] : null
     };
   })
 );


    // let id;
    //  if (this.router.getCurrentNavigation().extras.state)
    //    id = this.router.getCurrentNavigation().extras.state.id;

    //   if (id) {
    //      return this.rolesService.getById(id);
    //   } else {
    //       return null;
    //   }
  }
}



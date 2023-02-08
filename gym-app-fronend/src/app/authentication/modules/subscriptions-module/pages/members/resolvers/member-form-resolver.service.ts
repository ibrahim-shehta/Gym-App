import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { RolesService } from 'src/app/authentication/modules/user-management/pages/roles/service/roles.service';
import { MemberService } from '../services/member.service';
import { forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class MemberFormResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private memberService :MemberService,
    private rolesService: RolesService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
     let id;
     if (this.router.getCurrentNavigation().extras.state)
       id = this.router.getCurrentNavigation().extras.state.id;


      const arr: any = [
        this.rolesService.getAll()
      ];

      if (id) {
        arr.push(this.memberService.getById(id));
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

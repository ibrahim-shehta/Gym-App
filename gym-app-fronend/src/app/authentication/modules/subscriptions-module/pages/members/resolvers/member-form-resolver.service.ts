import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { MemberService } from '../services/member.service';

@Injectable()
export class MemberFormResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private memberService :MemberService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
     let id;
     if (this.router.getCurrentNavigation().extras.state)
       id = this.router.getCurrentNavigation().extras.state.id;

      if (id) {
         return this.memberService.getById(id);
      } else {
          return null;
      }
    }

}

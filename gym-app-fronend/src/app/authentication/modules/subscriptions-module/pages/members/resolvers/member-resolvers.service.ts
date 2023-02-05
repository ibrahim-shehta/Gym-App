import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { MemberService } from '../services/member.service';

@Injectable()
export class MemberResolversService {


  constructor(
    private memberersService :MemberService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return this.memberersService.filterWithPagination();
    }


}

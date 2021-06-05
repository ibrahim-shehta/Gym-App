import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { PlayersService } from '../services/players.service';

@Injectable()
export class PlayersFormResolverService implements Resolve<any> {

  constructor(
    private router :Router,
    private playersService :PlayersService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
     let id;
     if (this.router.getCurrentNavigation().extras.state)
       id = this.router.getCurrentNavigation().extras.state.id;

      if (id) {
         return this.playersService.getById(id);
      } else {
          return null;
      }
    }

}

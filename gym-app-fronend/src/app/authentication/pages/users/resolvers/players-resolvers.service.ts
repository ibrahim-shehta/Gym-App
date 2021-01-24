import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { PlayersService } from '../services/players.service';

@Injectable({
  providedIn: 'root'
})
export class PlayersResolversService {


  constructor(
    private playersService :PlayersService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      return this.playersService.filterWithPagination();
    }


}

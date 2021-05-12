import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { EquipmentService } from '../services/equipment-service';
@Injectable({
  providedIn: 'root'
})
export class EquipmentFormResolversService implements Resolve<any> {

  constructor(
    private router: Router,
    private equipmentService: EquipmentService
  ) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

     if (this.router.getCurrentNavigation().extras.state) {
       const id = this.router.getCurrentNavigation().extras.state.id;
       return this.equipmentService.getById(id);
     }

     return null;
    }
}

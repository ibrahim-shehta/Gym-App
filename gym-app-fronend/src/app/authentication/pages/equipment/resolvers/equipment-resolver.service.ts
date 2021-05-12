import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { EquipmentService } from '../services/equipment-service';

@Injectable({
  providedIn: 'root'
})
export class EquipmentResolverService implements Resolve<any> {

constructor(
  private equipmentService: EquipmentService
  ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.equipmentService.filterWithPagination();
  }


}

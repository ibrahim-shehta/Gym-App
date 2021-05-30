import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { EquipmentService } from '../services/equipment-service';
import { forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EquipmentResolverService implements Resolve<any> {

constructor(
  private equipmentService: EquipmentService
  ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return forkJoin([
      this.equipmentService.getStatusList('public_status'),
      this.equipmentService.filterWithPagination()
    ]);
    //return this.equipmentService.filterWithPagination();
  }


}

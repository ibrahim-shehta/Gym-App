import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipmentsRoutingModule } from './equipments-routing.module';
import { EquipmentComponent } from './equipment/screens/equipment/equipment.component';
import { EquipmentFormComponent } from './equipment/screens/equipment-form/equipment-form.component';
import { EquipmentResolverService } from './equipment/resolvers/equipment-resolver.service';
import { EquipmentFormResolversService } from './equipment/resolvers/equipment-form-resolvers.service';
import { SharedExercisesModule } from '../../shared-exercises/shared-exercises.module';


@NgModule({
  declarations: [
    EquipmentComponent,
    EquipmentFormComponent
  ],
  imports: [
    CommonModule,
    SharedExercisesModule,
    EquipmentsRoutingModule
  ],
  providers: [
    EquipmentResolverService,
    EquipmentFormResolversService
  ]
})
export class EquipmentModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquipmentComponent } from './equipment/screens/equipment/equipment.component';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { EquipmentResolverService } from './equipment/resolvers/equipment-resolver.service';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { EquipmentFormComponent } from './equipment/screens/equipment-form/equipment-form.component';
import { EquipmentFormResolversService } from './equipment/resolvers/equipment-form-resolvers.service';


const routes: Routes = [
  {
    path: "",
    component: EquipmentComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: EquipmentResolverService },
  },
  {
    path: AuthURL.Form,
    component: EquipmentFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: EquipmentFormResolversService },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EquipmentsRoutingModule { }

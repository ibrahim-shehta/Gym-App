import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';


const routes: Routes = [
  { path: AuthURL.ExcercisesCategory, loadChildren: () => import('./pages/categories/categories.module').then(m => m.CategoriesModule) },
  { path: AuthURL.Equipment, loadChildren: () => import('./pages/equipments/equipment.module').then(m => m.EquipmentModule) },
  { path: AuthURL.Exercise, loadChildren: () => import('./pages/exercises/exercises.module').then(m => m.ExercisesModule) },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExercisesModuleRoutingModule { }

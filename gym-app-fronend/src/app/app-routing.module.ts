import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';


@NgModule({
  imports: [RouterModule.forRoot([{ path: 'equipment', loadChildren: () => import('./authentication/modules/exercises-module/pages/equipment/equipment.module').then(m => m.EquipmentModule) }, { path: 'categories', loadChildren: () => import('./authentication/modules/exercises-module/pages/categories/categories.module').then(m => m.CategoriesModule) }, { path: 'exercises', loadChildren: () => import('./authentication/modules/exercises-module/pages/exercises/exercises.module').then(m => m.ExercisesModule) }])],
  exports: [RouterModule]
})
export class AppRoutingModule { }

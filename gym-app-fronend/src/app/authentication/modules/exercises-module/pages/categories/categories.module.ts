import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriesRoutingModule } from './categories-routing.module';
import { CategoriesComponent } from './categories/screens/categories/categories.component';
import { CategoriesFormComponent } from './categories/screens/categories-form/categories-form.component';
import { CategoriesResolverService } from './categories/resolvers/categories-resolver.service';
import { CategoriesFormResolversService } from './categories/resolvers/categories-form-resolvers.service';
import { SharedExercisesModule } from '../../shared-exercises/shared-exercises.module';


@NgModule({
  declarations: [
    CategoriesComponent,
    CategoriesFormComponent
  ],
  imports: [
    CommonModule,
    SharedExercisesModule,
    CategoriesRoutingModule
  ],
  providers: [
    CategoriesResolverService,
    CategoriesFormResolversService
  ]
})
export class CategoriesModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExercisesRoutingModule } from './exercises-routing.module';
import { ExerciseComponent } from './exercises/screens/categories/exercise.component';
import { ExerciseResolverService } from './exercises/resolvers/exercise-resolver.service';
import { ExerciseFormComponent } from './exercises/screens/categories-form/exercise-form.component';
import { ExerciseFormResolversService } from './exercises/resolvers/exercise-form-resolvers.service';
import { SharedExercisesModule } from '../../shared-exercises/shared-exercises.module';


@NgModule({
  declarations: [
    ExerciseComponent,
    ExerciseFormComponent
  ],
  imports: [
    CommonModule,
    SharedExercisesModule,
    ExercisesRoutingModule
  ],
  providers: [
    ExerciseResolverService,
    ExerciseFormResolversService
  ]
})
export class ExercisesModule { }

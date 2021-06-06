import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { ExerciseComponent } from './exercises/screens/categories/exercise.component';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { ExerciseResolverService } from './exercises/resolvers/exercise-resolver.service';
import { ExerciseFormComponent } from './exercises/screens/categories-form/exercise-form.component';
import { ExerciseFormResolversService } from './exercises/resolvers/exercise-form-resolvers.service';


const routes: Routes = [

  {
    path: "",
    component: ExerciseComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: ExerciseResolverService },
  },
  {
    path: AuthURL.Form,
    component: ExerciseFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: ExerciseFormResolversService },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExercisesRoutingModule { }

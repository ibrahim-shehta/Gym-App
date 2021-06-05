import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthenticationRouting } from './authentication.routing';
import { SharedsModule } from '../shareds/shareds.module';
import { SettingComponent } from './components/setting/setting.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CategoriesComponent } from './pages/exercises/categories/screens/categories/categories.component';
import { CategoriesFormComponent } from './pages/exercises/categories/screens/categories-form/categories-form.component';
import { ExerciseComponent } from './pages/exercises/exercises/screens/categories/exercise.component';
import { ExerciseFormComponent } from './pages/exercises/exercises/screens/categories-form/exercise-form.component';
import { EquipmentComponent } from './pages/equipment/screens/equipment/equipment.component';
import { EquipmentFormComponent } from './pages/equipment/screens/equipment-form/equipment-form.component';


@NgModule({
  declarations: [
    DashboardComponent,
    SettingComponent,
    ProfileComponent,
    CategoriesComponent,
    CategoriesFormComponent,
    ExerciseComponent,
    ExerciseFormComponent,
    EquipmentComponent,
    EquipmentFormComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRouting,
    SharedsModule
  ]
})
export class AuthenticationModule { }

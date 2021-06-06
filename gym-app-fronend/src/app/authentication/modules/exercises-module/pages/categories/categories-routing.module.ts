import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriesComponent } from './categories/screens/categories/categories.component';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { CategoriesResolverService } from './categories/resolvers/categories-resolver.service';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { CategoriesFormComponent } from './categories/screens/categories-form/categories-form.component';
import { CategoriesFormResolversService } from './categories/resolvers/categories-form-resolvers.service';


const routes: Routes = [
  {
    path: "",
    component: CategoriesComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: CategoriesResolverService },
  },
  {
    path: AuthURL.Form,
    component: CategoriesFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: CategoriesFormResolversService },
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoriesRoutingModule { }

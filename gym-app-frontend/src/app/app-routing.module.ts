import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutingUrls } from './core/constants/RoutingUrls';

const routes: Routes = [
  {path: '', redirectTo: RoutingUrls.AUTH, pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlansRoutingModule } from './plans-routing.module';
import { PlansComponent } from './screens/plans/plans.component';
import { SharedsModule } from 'src/app/shareds/shareds.module';
import { PlansFormComponent } from './screens/plans-form/plans-form.component';
import { PlansResolverService } from './resolvers/plans-resolver.service';
import { PlansFormResolversService } from './resolvers/plans-form-resolvers.service';
import { PlansViewComponent } from './screens/plans-view/plans-view.component';


@NgModule({
  declarations: [
    PlansComponent,
    PlansFormComponent,
    PlansViewComponent
  ],
  imports: [
    CommonModule,
    SharedsModule,
    PlansRoutingModule
  ],
  providers: [
    PlansResolverService,
    PlansFormResolversService
  ]
})
export class PlansModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlayersRoutingModule } from './players-routing.module';
import { SharedsModule } from 'src/app/shareds/shareds.module';
import { PlayerAttendanceHistoryResolverService } from './resolvers/player-attendance-history-resolver.service';
import { PlayersAttendanceService } from './resolvers/players-attendance.service';
import { PlayersFormResolverService } from './resolvers/players-form-resolver.service';
import { PlayersResolversService } from './resolvers/players-resolvers.service';
import { PlayersService } from 'src/app/authentication/modules/subscriptions-module/pages/players/services/players.service';
import { AttendanceService } from 'src/app/authentication/modules/subscriptions-module/pages/players/services/attendance.service';
import { PlayersComponent } from './screens/players/players.component';
import { PlayersFormComponent } from './screens/players-form/players-form.component';
import { PlyersViewComponent } from './screens/plyers-view/plyers-view.component';
import { PlayerAttendanceComponent } from './screens/player-attendance/player-attendance.component';
import { PlayerAttendanceHistoryComponent } from './screens/player-attendance-history/player-attendance-history.component';



@NgModule({
  declarations: [
    PlayersComponent,
    PlayersFormComponent,
    PlyersViewComponent,
    PlayerAttendanceComponent,
    PlayerAttendanceHistoryComponent
  ],
  imports: [
    CommonModule,
    SharedsModule,
    PlayersRoutingModule
  ],
  providers: [
    PlayersService,
    AttendanceService,
    PlayerAttendanceHistoryResolverService,
    PlayersAttendanceService,
    PlayersFormResolverService,
    PlayersResolversService,

  ]
})
export class PlayersModule { }

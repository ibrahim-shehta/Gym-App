import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { PlayersFormResolverService } from './resolvers/players-form-resolver.service';
import { PlayersResolversService } from './resolvers/players-resolvers.service';
import { PlayerAttendanceComponent } from './screens/player-attendance/player-attendance.component';
import { PlayersFormComponent } from './screens/players-form/players-form.component';
import { PlayersComponent } from './screens/players/players.component';
import { PlyersViewComponent } from './screens/plyers-view/plyers-view.component';
import { PlayersAttendanceService } from './resolvers/players-attendance.service';
import { PlayerAttendanceHistoryComponent } from './screens/player-attendance-history/player-attendance-history.component';
import { PlayerAttendanceHistoryResolverService } from './resolvers/player-attendance-history-resolver.service';

const routes: Routes = [

  {
    path: "",
    component: PlayersComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: PlayersResolversService },
  },
  {
    path: AuthURL.PlayersForm,
    component: PlayersFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: PlayersFormResolverService },
  }, {
    path: AuthURL.View,
    component: PlyersViewComponent,
    canActivate: [AuthGuardService],
    resolve: { form: PlayersFormResolverService },
  }, {
    path: AuthURL.Attendance,
    component: PlayerAttendanceComponent,
    canActivate: [AuthGuardService],
    resolve: { form: PlayersAttendanceService },
    children: [
      {
        path: '',
        component: PlayerAttendanceHistoryComponent,
        resolve: { dataList: PlayerAttendanceHistoryResolverService },

      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlayersRoutingModule { }

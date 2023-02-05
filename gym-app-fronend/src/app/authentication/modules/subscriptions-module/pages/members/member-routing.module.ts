import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { AuthGuardService } from 'src/app/core/services/auth-guard.service';
import { MemberAttendanceHistoryResolverService } from './resolvers/member-attendance-history-resolver.service';
import { MemberAttendanceService } from './resolvers/member-attendance.service';
import { MemberFormResolverService } from './resolvers/member-form-resolver.service';
import { MemberResolversService } from './resolvers/member-resolvers.service';
import { MemberAttendanceHistoryComponent } from './screens/member-attendance-history/member-attendance-history.component';
import { MemberAttendanceComponent } from './screens/member-attendance/member-attendance.component';
import { MemberFormComponent } from './screens/member-form/member-form.component';
import { MemberViewComponent } from './screens/member-view/member-view.component';
import { MemberComponent } from './screens/member/member.component';


const routes: Routes = [

  {
    path: "",
    component: MemberComponent,
    canActivate: [AuthGuardService],
    resolve: { dataList: MemberResolversService },
  },
  {
    path: AuthURL.MemberForm,
    component: MemberFormComponent,
    canActivate: [AuthGuardService],
    resolve: { form: MemberFormResolverService },
  }, {
    path: AuthURL.View,
    component: MemberViewComponent,
    canActivate: [AuthGuardService],
    resolve: { form: MemberFormResolverService },
  }, {
    path: AuthURL.Attendance,
    component: MemberAttendanceComponent,
    canActivate: [AuthGuardService],
    resolve: { form: MemberAttendanceService },
    children: [
      {
        path: '',
        component: MemberAttendanceHistoryComponent,
        resolve: { dataList: MemberAttendanceHistoryResolverService },

      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MembersRoutingModule { }

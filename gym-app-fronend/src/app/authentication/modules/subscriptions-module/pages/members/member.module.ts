import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MemberFormResolverService } from './resolvers/member-form-resolver.service';
import { MemberFormComponent } from './screens/member-form/member-form.component';
import { SharedSubscriptionsModule } from '../../shared-subscriptions/shared-subscriptions.module';
import { MemberComponent } from './screens/member/member.component';
import { MemberViewComponent } from './screens/member-view/member-view.component';
import { MemberAttendanceComponent } from './screens/member-attendance/member-attendance.component';
import { MemberAttendanceHistoryComponent } from './screens/member-attendance-history/member-attendance-history.component';
import { MembersRoutingModule } from './member-routing.module';
import { MemberAttendanceHistoryResolverService } from './resolvers/member-attendance-history-resolver.service';
import { MemberAttendanceService } from './resolvers/member-attendance.service';
import { MemberResolversService } from './resolvers/member-resolvers.service';
import { AttendanceService } from './services/attendance.service';



@NgModule({
  declarations: [
    MemberComponent,
    MemberFormComponent,
    MemberViewComponent,
    MemberAttendanceComponent,
    MemberAttendanceHistoryComponent
  ],
  imports: [
    CommonModule,
    SharedSubscriptionsModule,
    MembersRoutingModule
  ],
  providers: [
    AttendanceService,
    MemberAttendanceHistoryResolverService,
    MemberAttendanceService,
    MemberFormResolverService,
    MemberResolversService,

  ]
})
export class MemberModule { }

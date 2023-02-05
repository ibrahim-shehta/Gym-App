import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';
import { MemberAttendance, MemberAttendanceList } from '../model/MemberAttendance';

@Injectable()
export class AttendanceService  extends Baseservice<MemberAttendanceList, MemberAttendance> {

  baseUrl = environment.baseUrl + '/attendance'

  constructor(public http :HttpClient) {
    super(http);
  }

  getBaseUrl(): string {
    return this.baseUrl;
  }
}

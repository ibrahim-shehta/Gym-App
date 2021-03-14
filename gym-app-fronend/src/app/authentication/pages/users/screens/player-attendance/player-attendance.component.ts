import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ResponseStatus } from 'src/app/core/constants/response-status-enum';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { AttendanceService } from '../../services/attendance.service';
import { PlayersService } from '../../services/players.service';
@Component({
  selector: 'app-player-attendance',
  templateUrl: './player-attendance.component.html',
  styleUrls: ['./player-attendance.component.css']
})
export class PlayerAttendanceComponent extends BaseFormCompnent implements OnInit {
  userId;
  excercisesCategories :any[] = [];

  back :boolean = false;
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private _componentService :AttendanceService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = {user: {id: null}, excerciseCategory: {id: null}}
        if (this.router.getCurrentNavigation().extras.state)
          this.entity.user.id = this.router.getCurrentNavigation().extras.state.id;
        else
          this.back = true;
  }

  ngOnInit() :void {
    if (this.back)
      this.goBack();
    else
      this.getResolverData();
  }

  getResolverData() {
    this.excercisesCategories = this.activatedRoute.snapshot.data.form.data;
  }

  add(entity) :void {
    this.getService().add(entity).subscribe(res => {
      this.addSuccess();
      this.goBack();
    }, err => {
      this.backendError(err.error);
      if(err.error.status == ResponseStatus[ResponseStatus.CONFLICT]) {
        this.addSuccess();
        this.goBack();
      }
    })
  }

  getService() :AttendanceService {
    return this._componentService;
  }
}

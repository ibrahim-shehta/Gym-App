import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ExerciseList } from '../../models/Exercise';
import { ExerciseService } from '../../services/exercise-service';


@Component({
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent extends BaseTableComponent<ExerciseList> implements OnInit, OnDestroy {
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public exerciseService :ExerciseService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :ExerciseService {
    return this.exerciseService;
  }

  getFormUrl() :string {
    return AuthURL.Form;
  }

  ngOnDestroy() {
    super.onDestroy();
  }

}

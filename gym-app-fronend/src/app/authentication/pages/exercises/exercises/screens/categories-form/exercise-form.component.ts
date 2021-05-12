import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Equipment } from 'src/app/authentication/pages/equipment/models/Equipment';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { BaseExcerciseCategory } from '../../../categories/model/ExcerciseCategory';
import { Exercise } from '../../models/Exercise';
import { ExerciseService } from '../../services/exercise-service';


@Component({
  templateUrl: './exercise-form.component.html',
  styleUrls: ['./exercise-form.component.scss']
})
export class ExerciseFormComponent extends BaseFormCompnent<Exercise> implements OnInit {

  categories: [] = [];
  equipments: [] = [];

  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private exerciseService :ExerciseService
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Exercise();

  }

  ngOnInit() :void {
    this.entity = new Exercise();
    this.entity.category = new BaseExcerciseCategory();
    this.entity.equipment = new Equipment();
    this.modeInit();
  }

  getResolverData() {
    this.categories = this.activatedRoute.snapshot.data.form.categories.data;
    this.equipments = this.activatedRoute.snapshot.data.form.equipments.data;
    if (this.activatedRoute.snapshot.data.form.entity) {
      this.entity = this.activatedRoute.snapshot.data.form.entity.data;
      this.isEditMode = true;
    }
  }

  getService() :ExerciseService {
    return this.exerciseService;
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { CategoriesService } from '../../services/categories-service';

@Component({
  templateUrl: './categories-form.component.html',
  styleUrls: ['./categories-form.component.scss']
})
export class CategoriesFormComponent extends BaseFormCompnent implements OnInit {

  categories: [] = [];
  entity = {id: null, name: '', nextExcerciseCategory: {id: null}}
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private categoriesService :CategoriesService
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() :void {
    this.modeInit();
  }

  getResolverData() {
    this.categories = this.activatedRoute.snapshot.data.form.categories.data;
    if (this.activatedRoute.snapshot.data.form.entity) {
      this.entity = this.activatedRoute.snapshot.data.form.entity.data;
      if (!this.entity.nextExcerciseCategory) {
        this.entity.nextExcerciseCategory = {id: null}
      }
      this.isEditMode = true;
    }
  }

  getService() :CategoriesService {
    return this.categoriesService;
  }

}

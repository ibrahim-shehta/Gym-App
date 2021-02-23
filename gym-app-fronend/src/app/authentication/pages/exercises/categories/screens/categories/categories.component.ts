import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { CategoriesService } from '../../services/categories-service';


@Component({
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent extends BaseTableComponent implements OnInit {
  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public categoriesService :CategoriesService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() :void  {
    this.baseInit();
  }

  getService() :CategoriesService {
    return this.categoriesService;
  }

  getFormUrl() :string {
    return AuthURL.Form;
  }

}

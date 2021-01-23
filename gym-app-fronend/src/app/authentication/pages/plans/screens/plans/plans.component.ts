import { Component, OnInit, ɵConsole } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlansService } from '../../services/plans.service';


@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent extends BaseTableComponent implements OnInit {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    private planService: PlansService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

  ngOnInit() {
    this.getPage();
  }

  getPage() {
    this.planService.filterWithPagination(this.filterDataWithPaginationAndSort).subscribe(res => {
      this.dataList = res.data;
      this.totalRows = res.totalRows;
    }, err => {
      this.notificationService.showError('', err.error.message);
    });
  }

   add() {
     this.router.navigate([AuthURL.PlansForm], {relativeTo: this.activatedRoute});
   }

   edit(id) {
    this.router.navigate([AuthURL.PlansForm], {relativeTo: this.activatedRoute, state: {id: id}});
  }
}

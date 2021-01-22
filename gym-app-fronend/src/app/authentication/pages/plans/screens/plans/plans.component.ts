import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { PageChangedEvent } from 'ngx-bootstrap';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseComponent } from 'src/app/core/model/BaseComponent';
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
    private planService: PlansService,
    private notificationService: NotificationService,
    private translate: TranslateService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    super();
   }

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.planService.filterWithPagination(this.filterDataWithPaginationAndSort).subscribe(res => {
      console.log(res);
      this.dataList = res.data;
      this.totalRows = res.totalRows;
    }, err => {console.log('111111111111')
      console.log(err)}

    );
  }


   pageChanged(event: PageChangedEvent): void {
      console.log(event);
      this.filterDataWithPaginationAndSort.page = event.page - 1;
      this.getData();
   }

   add() {
     this.router.navigate([AuthURL.PlansForm], {relativeTo: this.activatedRoute});
   }

   edit(id) {
    this.router.navigate([AuthURL.PlansForm], {relativeTo: this.activatedRoute, state: {id: id}});
  }


}

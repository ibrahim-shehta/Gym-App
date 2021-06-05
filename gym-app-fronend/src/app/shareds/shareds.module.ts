import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginationModule } from 'ngx-bootstrap/pagination';

import { AuthNavbarComponent } from './components/auth-navbar/auth-navbar.component';
import { AuthSidebarComponent } from './components/auth-sidebar/auth-sidebar.component';
import { AuthContectComponent } from './components/auth-contect/auth-contect.component';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Ng2IziToastModule } from 'ng2-izitoast';
import { DataTablesModule } from 'angular-datatables';
import { AccountService } from './services/account.service';
import { TranslateModule } from '@ngx-translate/core';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { PaginationComponent } from './components/pagination/pagination.component';
import { TableContextMenuComponent } from './components/table-context-menu/table-context-menu.component';
import { PageHeaderComponent } from './components/page-header/page-header.component';
import { ViewEditActionsComponent } from './components/view-edit-actions/view-edit-actions.component';
import { ModalComponent } from './components/modal/modal.component';
import { StatusListFilterComponent } from './components/status-list-filter/status-list-filter.component';
import { UploadComponent } from './components/upload/upload.component';
import { StatusComponent } from './components/status/status.component';
import { AuditComponent } from './components/audit/audit.component';
import { SelectPlanComponent } from './components/select-plan/select-plan.component';
import { PlansDetailsComponent } from '../authentication/modules/subscriptions-module/components/plans-details/plans-details.component';
import { SubscriptionsDetailsComponent } from '../authentication/modules/subscriptions-module/components/subscriptions-details/subscriptions-details.component';
import { PlayerDetailsComponent } from '../authentication/modules/subscriptions-module/components/player-details/player-details.component';

@NgModule({
  declarations: [
    AuthNavbarComponent,
     AuthSidebarComponent,
     AuthContectComponent,
     PaginationComponent,
     TableContextMenuComponent,
     PageHeaderComponent,
     ViewEditActionsComponent,
     ModalComponent,
     StatusListFilterComponent,
     UploadComponent,
     StatusComponent,
     AuditComponent,
     SelectPlanComponent,
     PlansDetailsComponent,
     SubscriptionsDetailsComponent,
     PlayerDetailsComponent
    ],
  imports: [
    CommonModule,
    BsDropdownModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    Ng2IziToastModule,
    DataTablesModule,
    TranslateModule,
    PaginationModule.forRoot()
  ],
  exports: [
    AuthNavbarComponent,
    AuthSidebarComponent,
    BsDropdownModule,
    AuthContectComponent,
    ReactiveFormsModule,
    FormsModule,
    Ng2IziToastModule,
    DataTablesModule,
    TranslateModule,
    PaginationModule,
    PaginationComponent,
    TableContextMenuComponent,
    PageHeaderComponent,
    ViewEditActionsComponent,
    ModalComponent,
    StatusListFilterComponent,
    UploadComponent,
    StatusComponent,
    AuditComponent,
    SelectPlanComponent,
    PlansDetailsComponent,
    SubscriptionsDetailsComponent,
    PlayerDetailsComponent
  ],
  providers: [
    AccountService
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
})
export class SharedsModule { }

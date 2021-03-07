import { NgModule } from '@angular/core';
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
     StatusListFilterComponent
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
    StatusListFilterComponent
  ],
  providers: [
    AccountService
  ]
})
export class SharedsModule { }

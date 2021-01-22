import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BsDropdownModule, PaginationConfig, PaginationModule } from 'ngx-bootstrap';
import { AuthNavbarComponent } from './components/auth-navbar/auth-navbar.component';
import { AuthSidebarComponent } from './components/auth-sidebar/auth-sidebar.component';
import { AuthContectComponent } from './components/auth-contect/auth-contect.component';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Ng2IziToastModule } from 'ng2-izitoast';
import { DataTablesModule } from 'angular-datatables';
import { AccountService } from './services/account.service';
import { TranslateModule } from '@ngx-translate/core';

@NgModule({
  declarations: [
    AuthNavbarComponent,
     AuthSidebarComponent,
     AuthContectComponent
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
    PaginationModule
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
    PaginationModule
  ],
  providers: [
    AccountService,
    PaginationConfig
  ]
})
export class SharedsModule { }
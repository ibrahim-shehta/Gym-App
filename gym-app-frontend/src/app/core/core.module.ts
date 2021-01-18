import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';



@NgModule({
  declarations: [
  HeaderComponent,
  FooterComponent
  ],

  imports: [
    CommonModule,
    FormsModule,
    ToastrModule,
    TranslateModule
  ],

  exports: [
    // modules
    CommonModule,
    FormsModule,
    TranslateModule,
    ToastrModule,

    // components
    HeaderComponent,
    FooterComponent

    // dirctives

  ]
})
export class CoreModule { }

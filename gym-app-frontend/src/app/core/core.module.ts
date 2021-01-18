import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './service/auth.service';
import { AuthGuardService } from './service/auth-guard.service';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ToastrModule } from 'ngx-toastr';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { HttpClient } from '@angular/common/http';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
  HeaderComponent,
  FooterComponent
  ],

  imports: [
    CommonModule,
    FormsModule,

    ToastrModule.forRoot(),// toaster module
    TranslateModule.forRoot({ // translate module
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
  ],

  providers: [
    AuthService,
    AuthGuardService
  ],

  exports: [
    // modules
    CommonModule,
    TranslateModule,
    ToastrModule,
    FormsModule,

    // components
    HeaderComponent,
    FooterComponent

    // dirctives

  ]
})
export class CoreModule { }

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

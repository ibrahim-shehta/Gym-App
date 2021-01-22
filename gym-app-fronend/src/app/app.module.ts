import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { AppRouting } from './app.routing';
import { SharedsModule } from './shareds/shareds.module';
import { RegisterComponent } from './components/register/register.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { NotificationService } from './core/services/notification.service';
import { AuthServiceService } from './components/services/auth-service.service';
import { AuthService } from './core/services/auth.service';
import { Ng2IzitoastService } from 'ng2-izitoast';
import { AuthInterceptorService } from './core/interceptors/auth-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRouting,
    SharedsModule,
    HttpClientModule,


    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
  ],
  providers: [
    NotificationService,
    AuthServiceService,
    AuthService,
    Ng2IzitoastService,
      { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true }


  ],

  bootstrap: [AppComponent]
})
export class AppModule { }

// required for AOT compilation use last beacuse this make problem with intenceptor
// export function HttpLoaderFactory(http: HttpClient) {
//   return new TranslateHttpLoader(http, './assets/i18n/', '.json');
// }

export function HttpLoaderFactory(http: HttpClient) {
  const path = window.location.origin + '/assets/i18n/';
  return new TranslateHttpLoader(http, path, '.json');
}

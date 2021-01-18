import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ScreensModule } from './screens/screens.module';
import { CoreModule } from './core/core.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule, // required to ruan angular app in browser
    BrowserAnimationsModule, // important to use toaster
    HttpClientModule, // important to use translate

    CoreModule,
    ScreensModule,
    AppRoutingModule,// root routing

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { StorageKeys } from './core/constants/StorageKeys';
declare const App: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular';

  constructor(public translate: TranslateService) { }
  ngOnInit() {
    this.initTranslation();
    App.initialLoadPage();
  }

  initTranslation() {
    this.translate.addLangs(['en', 'ar']);
    this.translate.setDefaultLang('en');
    const currentLang = localStorage.getItem(StorageKeys.APP_LANG);
    document.dir = currentLang == 'ar' ? 'rtl' : 'ltr';
    this.translate.use(currentLang ? currentLang : 'en');
  }
}

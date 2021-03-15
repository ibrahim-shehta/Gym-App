import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { StorageKeys } from './core/constants/StorageKeys';
import { AppStateService } from './core/services/app-state.service';
import { AppUtils } from './core/utils/app-utils';
declare const App: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular';

  constructor(
    public translate: TranslateService,
    private appStateService :AppStateService
    ) { }
  ngOnInit() {
    this.loadStateIfUserLogged();
    this.initTranslation();
  }

  loadStateIfUserLogged () {
    const userObj = localStorage.getItem(StorageKeys.LOGGED_USER);
    if (userObj) {
      const user = JSON.parse(userObj).data.user;
      this.appStateService.changeProfileImage(user.imageName);
    }
  }

  initTranslation() {
    this.translate.addLangs(['en', 'ar']);
    this.translate.setDefaultLang('ar');
    const currentLang = localStorage.getItem(StorageKeys.APP_LANG);
    document.dir =  currentLang == 'en' ? 'ltr' : 'rtl';
    this.loadStyles(currentLang ? currentLang : 'ar');
    this.translate.use(currentLang ? currentLang : 'ar');
  }


  loadStyles(lang)  {
    if (lang == 'ar') {
      AppUtils.loadStyles('assets/css/them/rtl/rtl.css');
      AppUtils.loadStyles('assets/css/them/common/custom.css');
      AppUtils.loadStyles('assets/css/them/rtl/custom-rtl.css');
    } else {
      AppUtils.loadStyles('assets/css/them/common/custom.css');
      AppUtils.loadStyles('assets/css/them/ltr/custom-ltr.css');
    }
  }
}

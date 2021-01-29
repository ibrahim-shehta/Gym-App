import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { StorageKeys } from './core/constants/StorageKeys';
import { AppUtils } from './core/utils/app-utils';
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
    //App.initialLoadPage();

  //  this.loadScripts();
  }

  initTranslation() {
    this.translate.addLangs(['en', 'ar']);
    this.translate.setDefaultLang('en');
    const currentLang = localStorage.getItem(StorageKeys.APP_LANG);
    document.dir = currentLang == 'ar' ? 'rtl' : 'ltr';
    this.loadStyles(currentLang);
    this.translate.use(currentLang ? currentLang : 'en');
  }


  loadStyles(lang)  {
    // AppUtils.loadStyles('assets/css/them/general/bootstrap.min.css');

    // AppUtils.loadStyles('assets/css/them/libs/iziToast.min.css');
    // AppUtils.loadStyles('assets/css/them/libs/datatables.min.css');
    // AppUtils.loadStyles('assets/css/them/libs/dataTables.bootstrap4.min.css');
    // AppUtils.loadStyles('assets/css/them/libs/select.bootstrap4.min.css');

    // AppUtils.loadStyles('assets/css/them/template/style.css');
    // AppUtils.loadStyles('assets/css/them/template/components.css');

    if (lang == 'ar') {
      AppUtils.loadStyles('assets/css/them/rtl/rtl.css');
      AppUtils.loadStyles('assets/css/them/common/custom.css');
      AppUtils.loadStyles('assets/css/them/rtl/custom-rtl.css');
    } else {
      AppUtils.loadStyles('assets/css/them/common/custom.css');
      AppUtils.loadStyles('assets/css/them/ltr/custom-ltr.css');
    }
  }

  loadScripts() {
    AppUtils.loadScript('assets/js/general/jquery.min.js');
    AppUtils.loadScript('assets/js/general/popper.js');
    AppUtils.loadScript('assets/js/general/tooltip.js');
    AppUtils.loadScript('assets/js/general/bootstrap.min.js');
    AppUtils.loadScript('assets/js/general/jquery.nicescroll.min.js');
    AppUtils.loadScript('assets/js/general/moment.min.js');
    AppUtils.loadScript('assets/js/stisla.js');

    AppUtils.loadScript('assets/js/libs/iziToast.min.js');

    AppUtils.loadScript('assets/js/page/modules-toastr.js');

    AppUtils.loadScript('assets/js/scripts.js');
    AppUtils.loadScript('assets/js/custom.js');
  }
}

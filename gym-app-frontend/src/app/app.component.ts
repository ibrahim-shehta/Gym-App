import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { StorageKeys } from './common/constants/StorageKeys';
import { NotificationService } from './common/service/notification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  app = 'Super Gym';

    constructor(public translate: TranslateService, private notifyService : NotificationService) {
      translate.addLangs(['en', 'ar']);
      translate.setDefaultLang('en');

     // localStorage.setItem(StorageKeys.APP_LANG, 'ar');
      const currentLang = localStorage.getItem(StorageKeys.APP_LANG);
      translate.use(localStorage.currentLang ? currentLang : 'en');
    }



    showToasterSuccess(){
      this.notifyService.showSuccess("Data shown successfully !!", "ItSolutionStuff.com")
  }

  showToasterError(){
      this.notifyService.showError("Something is wrong", "ItSolutionStuff.com")
  }

  showToasterInfo(){
      this.notifyService.showInfo("This is info", "ItSolutionStuff.com")
  }

  showToasterWarning(){
      this.notifyService.showWarning("This is warning", "ItSolutionStuff.com")
  }
}

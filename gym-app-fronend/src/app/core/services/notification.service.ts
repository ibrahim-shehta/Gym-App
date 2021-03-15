import { Injectable } from '@angular/core';
import { Ng2IzitoastService } from 'ng2-izitoast';
import { StorageKeys } from '../constants/StorageKeys';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

appLang;
  constructor(
    private toastr: Ng2IzitoastService
    ) {
      this.appLang = localStorage.getItem(StorageKeys.APP_LANG);
     }

  showSuccess(message, title){
      this.toastr.success(this.createtoasterObj(message, title));
  }

  showError(message, title){
      this.toastr.error(this.createtoasterObj(message, title))
  }

  showInfo(message, title){
      this.toastr.info(this.createtoasterObj(message, title))
  }

  showWarning(message, title){
      this.toastr.warning(this.createtoasterObj(message, title))
  }

  private createtoasterObj(message, title) : {}{
    return {
      title: message,
      message: title,
      position: this.appLang == 'en' ? 'topRight' : 'topLeft'
    };
  }
}

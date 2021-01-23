import { ActivatedRoute, Router } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { ResponseStatus } from "../constants/response-status-enum";
import { NotificationService } from "../services/notification.service";

export class BaseComponent {

  constructor(
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {}


  backendError(error :any) {
    if (!error) {
      return;
    }

    switch(error.status) {
      case ResponseStatus[ResponseStatus.BAD_REQUEST] :
        if (error.subErrors && error.subErrors.length > 0) {
          (<[]> (error.subErrors)).forEach( (i :any)=> {
            this.notificationService.showError('', i.message);
          });
        } else {
          this.commonError();
        }
        break;
      case ResponseStatus[ResponseStatus.NOT_FOUND]:
      case ResponseStatus[ResponseStatus.INTERNAL_SERVER_ERROR]:
      case ResponseStatus[ResponseStatus.METHOD_NOT_ALLOWED]:
        this.notificationService.showError('', error.message);
        break;
      default:
        this.commonError();
    }
  }

  private commonError() {
    this.notificationService.showError('', this.translateService.instant('COMMON.ERROR_OCCURED'));
  }

}

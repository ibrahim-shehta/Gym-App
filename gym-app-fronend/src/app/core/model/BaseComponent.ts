import { TranslateService } from "@ngx-translate/core";
import { ResponseStatus } from "../constants/response-status-enum";
import { NotificationService } from "../services/notification.service";
import { Baseservice } from "./BaseService";
import { AuthURL } from '../../authentication/authentication.url';

export abstract class BaseComponent {

  AuthURL = AuthURL;

  constructor(
    public notificationService :NotificationService,
    public translateService :TranslateService
  ) {}


  abstract  getService() :Baseservice<any, any>;

  backendError(error :any) :void {
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
      case ResponseStatus[ResponseStatus.CONFLICT]:
        this.notificationService.showInfo('', error.message);
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

  private commonError() :void {
    this.notificationService.showError('', this.translateService.instant('COMMON.ERROR_OCCURED'));
  }

}

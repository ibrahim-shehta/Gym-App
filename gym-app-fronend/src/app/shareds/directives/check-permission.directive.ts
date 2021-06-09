import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';
import { AppStateService } from '../../core/services/app-state.service';

@Directive({
  selector: '[appCheckPermission]'
})
export class CheckPermissionDirective {

  @Input() set appCheckPermission(path: string[]) {
    console.log(path);
    if (path[0] && path[1] && path[2]) {
        const isValueEist = this.appStateService.permissions[path[0]]['children'][path[1]]['children'][path[2]];
        console.log('check value is exist', this.appStateService.permissions[path[0]]['children'][path[1]]['children'][path[2]])
        if (isValueEist) {
          this.viewContainer.createEmbeddedView(this.templateRef);
        } else {
          this.viewContainer.clear();
        }
    }
  }

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef,
    private appStateService: AppStateService
  ) {}


}

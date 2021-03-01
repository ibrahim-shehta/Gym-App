import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-view-edit-actions',
  templateUrl: './view-edit-actions.component.html',
  styleUrls: ['./view-edit-actions.component.css']
})
export class ViewEditActionsComponent  {

  @Input() showSave :boolean = false;
  @Input() showBack :boolean = false;
  @Input() showCancel :boolean = false;

  @Output() onClickBack = new EventEmitter<any>();
  @Output() onClickCancel = new EventEmitter<any>();

  onClickBackHandler() {
    this.onClickBack.emit();
  }

  onClickCancelHandler() {
    this.onClickCancel.emit();
  }


}

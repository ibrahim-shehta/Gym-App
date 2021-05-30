import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { NotificationService } from 'src/app/core/services/notification.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {
  @Input() entity :any;
  @Input() statusList :any[] = [];
  @Input() service :any;
  @Output() onCloseDialog = new EventEmitter<any>();
  @Output() onSaveStatusEvent = new EventEmitter<any>();

  statusName: string = '';
  filteredList: any[];
  entityBackup;

  constructor(
    private translateService: TranslateService,
    private notificationService: NotificationService
  ) { }

  ngOnInit(): void {
    this.filteredList = this.statusList.filter(item => {
      if (item.value == this.entity.status) {
        this.statusName = item.name;
        return false;
      }
      return true;
    });
    this.entityBackup = {...this.entity};
    this.entityBackup.statusReason = '';
    this.entityBackup.status = null;
  }

  onClickSaveStatus(form :NgForm) {
    if(form.invalid) {
      this.notificationService.showError('', this.translateService.instant('COMMON.VALIDATION_ERROR'));
      return;
    }
    this.onSaveStatusEvent.emit(this.entityBackup);
  }

  onClickCancel() {
    this.onCloseDialog.emit();
  }
}

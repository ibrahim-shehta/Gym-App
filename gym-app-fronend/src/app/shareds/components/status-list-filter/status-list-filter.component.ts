import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-status-list-filter',
  templateUrl: './status-list-filter.component.html',
  styleUrls: ['./status-list-filter.component.css']
})
export class StatusListFilterComponent {

  @Input() statusList :[] = [];
  @Input() selectedStatusIndex :number;
  @Output() onSelectStatus = new EventEmitter<any>();

  onSelectStatusHandler(status) {
    this.onSelectStatus.emit(status);
  }
}

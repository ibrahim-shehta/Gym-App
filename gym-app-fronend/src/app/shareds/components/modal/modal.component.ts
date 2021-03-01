import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  @Input() show :boolean = false;
  @Input() width :number = 50;
  @Output() onClose = new EventEmitter<any>();

  onCloseHandler() {
    this.show = false;
    this.onClose.emit();
  }

}

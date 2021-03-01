import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-table-context-menu',
  templateUrl: './table-context-menu.component.html',
  styleUrls: ['./table-context-menu.component.css']
})
export class TableContextMenuComponent implements OnInit {

  @Input() showEdit :boolean = false;
  @Output() editHandler = new EventEmitter<any>();

  @Input() showView :boolean = false;
  @Output() viewHandler = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  onEdit() {
    this.editHandler.emit();
  }

  onView() {
    this.viewHandler.emit();
  }
}

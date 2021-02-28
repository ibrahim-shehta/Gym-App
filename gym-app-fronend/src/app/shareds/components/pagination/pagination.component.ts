import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  @Input() totalRows;
  @Input() size;
  @Input() maxSize;
  @Input() currentPage;

  @Output() pageChanged = new EventEmitter<any>();


  constructor() { }

  ngOnInit(): void {
  }


  pageChangedEvent(e) {
    console.log(e);
    this.pageChanged.emit(e);
  }
}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';

@Component({
  selector: 'app-page-header',
  templateUrl: './page-header.component.html',
  styleUrls: ['./page-header.component.css']
})
export class PageHeaderComponent implements OnInit {

  @Input() pageHeader :string = '';
  @Input() sectionHeader :string = '';
  @Input() isTablePage :boolean = false;
  @Input() service :Baseservice<any, any>;

  @Output() onSearch = new EventEmitter<any>();
  @Output() onStopSearch = new EventEmitter<any>();
  @Output() onAdd = new EventEmitter<any>();


  constructor() { }

  ngOnInit(): void {
  }

  onSearchHandler() {
    this.onSearch.emit();
  }

  onStopSearchHanlder() {
    this.onStopSearch.emit();
  }

  onAddHandler() {
    this.onAdd.emit();
  }
}

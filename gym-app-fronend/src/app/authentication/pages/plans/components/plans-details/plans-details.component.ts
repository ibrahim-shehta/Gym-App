import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-plans-details',
  templateUrl: './plans-details.component.html',
  styleUrls: ['./plans-details.component.css']
})
export class PlansDetailsComponent implements OnInit {

  @Input() entity;
  constructor() { }

  ngOnInit(): void {
  }

}

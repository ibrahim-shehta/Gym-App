import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-subscriptions-details',
  templateUrl: './subscriptions-details.component.html',
  styleUrls: ['./subscriptions-details.component.css']
})
export class SubscriptionsDetailsComponent implements OnInit {

  @Input() entity :any = {user: {}};
  constructor() { }

  ngOnInit(): void {
  }

}

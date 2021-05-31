import { Component, Input } from '@angular/core';
import { AuditEntity } from 'src/app/core/model/AuditEntity';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['./audit.component.css']
})
export class AuditComponent  {

  @Input() audit :AuditEntity;

  constructor() { }

}

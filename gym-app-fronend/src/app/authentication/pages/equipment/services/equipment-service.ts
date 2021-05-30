import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseServiceWithStatus } from 'src/app/core/model/BaseServiceWithStatus';
import { environment } from 'src/environments/environment';
import { Equipment } from '../models/Equipment';

@Injectable({
  providedIn: 'root'
})
export class EquipmentService extends BaseServiceWithStatus<Equipment, Equipment> {

  baseUrl = environment.baseUrl + '/equipment';

  constructor(public http: HttpClient) {
    super(http);
   }

   getBaseUrl(): string {
     return this.baseUrl;
   }

}

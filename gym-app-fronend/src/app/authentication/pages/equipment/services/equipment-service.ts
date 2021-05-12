import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';
import { Equipment } from '../models/Equipment';

@Injectable({
  providedIn: 'root'
})
export class EquipmentService extends Baseservice<Equipment, Equipment> {

  baseUrl = environment.baseUrl + '/equipment';

  constructor(public http: HttpClient) {
    super(http);
   }

   getBaseUrl(): string {
     return this.baseUrl;
   }

}
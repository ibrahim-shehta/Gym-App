import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseAuditService } from 'src/app/core/model/BaseAuditService';
import { environment } from 'src/environments/environment';
import { ExcerciseCategory, ExcerciseCategoryLight } from '../model/ExcerciseCategory';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService extends BaseAuditService<ExcerciseCategoryLight, ExcerciseCategory> {

  baseUrl = environment.baseUrl + '/excercises/category';

  constructor(public http: HttpClient) {
    super(http);
   }

   getBaseUrl(): string {
     return this.baseUrl;
   }

}

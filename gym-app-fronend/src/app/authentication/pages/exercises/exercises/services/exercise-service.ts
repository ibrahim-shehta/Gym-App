import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Baseservice } from 'src/app/core/model/BaseService';
import { environment } from 'src/environments/environment';
import { Exercise, ExerciseList } from '../models/Exercise';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService extends Baseservice<ExerciseList, Exercise> {

  baseUrl = environment.baseUrl + '/excercises/exersise';

  constructor(public http: HttpClient) {
    super(http);
   }

   getBaseUrl(): string {
     return this.baseUrl;
   }

}

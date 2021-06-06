import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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


   uploadFile(file: File, id: number): Observable<HttpEvent<any>>  {
    const formData: FormData = new FormData();
    formData.append('file', file);
    const req = new HttpRequest('POST', `${this.baseUrl}/upload/${id}`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }
}

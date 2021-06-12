import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Permission } from '../model/Permission';
import { Observable } from 'rxjs';

@Injectable()
export class PermissionService {
  baseUrl = environment.baseUrl + '/permissions';

  constructor(private httpClient: HttpClient) {}

  getAll() :Observable<Permission> {
    return this.httpClient.get<Permission>(this.baseUrl);
  }
}

import { Injectable } from '@angular/core';
import { BaseAuditService } from 'src/app/core/model/BaseAuditService';
import { environment } from 'src/environments/environment';
import { Role } from '../model/Role';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RolesService extends BaseAuditService<Role, Role> {
  baseUrl = environment.baseUrl + '/role';

  constructor(private httpClient: HttpClient) {
    super(httpClient);
   }

  getBaseUrl() {
    return this.baseUrl;
  }
}

import { BaseEntity } from '../../../../../../core/model/BaseEntity';
import { Permission } from './Permission';

export class Role extends BaseEntity {
  name: string;
  permissions: Permission[]
}

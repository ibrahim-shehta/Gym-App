import { BaseEntity } from '../../../../../../core/model/BaseEntity';
export class Permission extends BaseEntity {

  name: string;
  code: string;
  module: boolean;
  screen: boolean;
  icon: string;
  parentId: number;
  path: string;
}

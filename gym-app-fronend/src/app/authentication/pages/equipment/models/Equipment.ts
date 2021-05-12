import { BaseEntity } from "src/app/core/model/BaseEntity";

export class Equipment extends BaseEntity {
  name :string;
  description: string;
  code: string;
  statusReason: string;
  isActive: boolean;
}

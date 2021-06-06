import { BaseStatusEntity } from "src/app/core/model/BaseStatusEntity";

export class Equipment extends BaseStatusEntity {
  name :string;
  description: string;
  code: string;
  statusReason: string;
  isActive: boolean;
}

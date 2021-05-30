import { BaseEntity } from "./BaseEntity";

export class BaseStatusEntity extends BaseEntity {
  status :number;
  statusReason: string;
  statusDate: Date;
}

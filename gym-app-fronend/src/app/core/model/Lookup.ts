import { BaseEntity } from "./BaseEntity";

export class Lookup extends BaseEntity {
  name: string;
  value: string;
  sortRank :number;
}

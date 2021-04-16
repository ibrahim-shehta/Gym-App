import { BaseEntity } from "src/app/core/model/BaseEntity";

class BasePlan extends BaseEntity {
  name :string;
  description :string;
  price :number;
  numberOfDays :number;
  numberOfReservedDays :number;
  discount :number;
  isSpecial :boolean;
  isActive :boolean;
}

export class Plan extends BasePlan {

}

export class PlanList extends BasePlan {

}

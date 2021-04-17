import { BaseEntity } from "src/app/core/model/BaseEntity";

class BasePlan extends BaseEntity {
  name :string;
  description :string;
  price :number;
  numberOfDays :number;
  numberOfReservedDays :number;
  numberOfInvitations :number;
  discount :number;
  special :boolean;
  isActive :boolean;
}

export class Plan extends BasePlan {

}

export class PlanList extends BasePlan {

}

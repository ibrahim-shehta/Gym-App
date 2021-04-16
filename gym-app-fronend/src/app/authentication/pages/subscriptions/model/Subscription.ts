import { BaseEntity } from "src/app/core/model/BaseEntity";
import { Plan } from "../../plans/model/Plan";

class BaseSubscription extends BaseEntity {
  subscriptionNumber :string;
  statusReason :string;
  status :string;
  price :number;
  paidAmount :number;
  requiredAmount :number;
  startDate :Date;
  endDate :Date;
}

export class Subscription extends BaseSubscription {
  plan :Plan = new Plan();
  user : any = {};
  numberOfDays :number;
  numberOfReservedDays :number;
  numberOfInvitations :number;
  discount :number;
  isSpecial :boolean;
}

export class SubscriptionList extends BaseSubscription {
  planName :string;
  playerName :string;
}

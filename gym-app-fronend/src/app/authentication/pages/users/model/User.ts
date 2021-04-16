import { BaseEntity } from "src/app/core/model/BaseEntity";

class BaseUser extends BaseEntity {
  name :string;
  email :string;
  username :string;
  mobile :string;
  address :string;
  imageName :string;
}

class BasePlayer extends BaseUser {

}

export class Player extends BasePlayer {
  birthDate :Date;
  // isActive :boolean;
  // isDeleted :boolean;
  // isBlocked :boolean;
  // password :string;
  userType :string;
}

export class PlayerList extends BasePlayer {

}

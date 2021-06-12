import { Role } from "src/app/authentication/modules/user-management/pages/roles/model/Role";
import { BaseEntity } from "src/app/core/model/BaseEntity";

class BaseUser extends BaseEntity {
  name :string;
  email :string;
  username :string;
  mobile :string;
  address :string;
  imageName :string;
  userType :string;
}

class BasePlayer extends BaseUser {

}

export class Player extends BasePlayer {
  birthDate :Date;
}

export class PlayerList extends BasePlayer {

}

export class BaseEmployee extends BaseUser {

}

export class Employee extends BasePlayer {
  birthDate :Date;
  roles: Role[]
}

export class EmployeeList extends BasePlayer {

}

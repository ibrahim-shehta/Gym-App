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
  status :number = 1;
}

class BaseMember extends BaseUser {

}

export class Member extends BaseMember {
  birthDate :Date;
}

export class MemberList extends BaseMember {

}

export class BaseEmployee extends BaseUser {

}

export class Employee extends BaseUser {
  birthDate :Date;
  roles: Role[]
}

export class EmployeeList extends BaseUser {

}

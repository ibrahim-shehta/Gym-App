import { ExcerciseCategory } from "src/app/authentication/modules/exercises-module/pages/categories/categories/model/ExcerciseCategory";
import { BaseEntity } from "src/app/core/model/BaseEntity";
import { Member } from "src/app/core/model/User";

class BaseMemberAttendance extends BaseEntity {
  date: Date;
  signIn :string;
  signOut :string;
}

export class MemberAttendance extends BaseMemberAttendance {
  user :Member = new Member();
  excerciseCategory :ExcerciseCategory = new ExcerciseCategory();
}

export class MemberAttendanceList extends BaseMemberAttendance {
  excerciseCategoryName :string;
}

import { ExcerciseCategory } from "src/app/authentication/modules/exercises-module/pages/categories/categories/model/ExcerciseCategory";
import { BaseEntity } from "src/app/core/model/BaseEntity";
import { Player } from "./User";

class BasePlayerAttendance extends BaseEntity {
  date: Date;
  signIn :string;
  signOut :string;
}

export class PlayerAttendance extends BasePlayerAttendance {
  user :Player = new Player();
  excerciseCategory :ExcerciseCategory = new ExcerciseCategory();
}

export class PlayerAttendanceList extends BasePlayerAttendance {
  excerciseCategoryName :string;
}

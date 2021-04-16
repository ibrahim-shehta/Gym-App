import { BaseEntity } from "src/app/core/model/BaseEntity";

class BaseExcerciseCategory extends BaseEntity {
  name;
}

export class ExcerciseCategory extends BaseExcerciseCategory {
  nextExcerciseCategory :ExcerciseCategory;
}

export class ExcerciseCategoryLight  extends BaseExcerciseCategory {
  nextExcerciseCategoryName :string;
}

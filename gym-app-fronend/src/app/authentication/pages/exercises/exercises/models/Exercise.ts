import { BaseEntity } from "src/app/core/model/BaseEntity";
import { BaseExcerciseCategory } from "src/app/authentication/pages/exercises/categories/model/ExcerciseCategory"
import { Equipment } from "../../../equipment/models/Equipment";
export class BaseExercise extends BaseEntity {
  name: string;
  description: string;
  imagePath: string;
  vedioPath: string;
  defaultCount: number;
  isActive: boolean = true;
}

export class Exercise extends BaseExercise {
  category: BaseExcerciseCategory;
  equipment: Equipment;
}

export class ExerciseList  extends BaseExercise {
  exerciseCategoryName: string;
  equipmentName: string;
}

import { BaseEntity } from "src/app/core/model/BaseEntity";
import { BaseExcerciseCategory } from "../../../categories/categories/model/ExcerciseCategory";
import { Equipment } from "../../../equipments/equipment/models/Equipment";
export class BaseExercise extends BaseEntity {
  name: string;
  description: string;
  imageName: string;
  videoName: string;
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

import { BaseComponent } from "./BaseComponent";
import { FilterDataWithPaginationAndSort } from "./FilterDataWithPaginationAndSort";

export class BaseTableComponent extends BaseComponent {
  filterDataWithPaginationAndSort :FilterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
  dataList :any[] = [];
  totalRows :number;
  directionLinks :boolean = false;
  boundaryLinks :boolean = true;
  lastText :string = null;
  firstText :string = null;
  maxSize :number = 10;


}

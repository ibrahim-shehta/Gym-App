import { FilterDataWithPaginationAndSort } from "./FilterDataWithPaginationAndSort";

export abstract  class Baseservice {
  filterDataWithPaginationAndSort: FilterDataWithPaginationAndSort = new FilterDataWithPaginationAndSort();
  totalRows :number;
  searchText;
  isClickSearch;
}

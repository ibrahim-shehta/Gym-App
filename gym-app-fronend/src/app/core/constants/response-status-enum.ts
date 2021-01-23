export enum ResponseStatus {
  NOT_FOUND, // entity or api not found (404)
  BAD_REQUEST, // validation errors (duplicate or constrains) binding errors or method argument not valid (400)
  INTERNAL_SERVER_ERROR, // system error (500)
  METHOD_NOT_ALLOWED, // not allowed method (405)

}

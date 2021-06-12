import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class AppStateService {
  profileImage = new BehaviorSubject<string>(null);
  permissions: any = {};

  constructor() {}

  changeProfileImage(image) {
    this.profileImage.next(image);
  }

  setPermission(permissions: any[]) {
    var map = {},
      node,
      roots = {},
      i;

    for (i = 0; i < permissions.length; i++) {
      map[permissions[i].id] = i;
      permissions[i].children = {};
    }
    for (i = 0; i < permissions.length; i += 1) {
      node = permissions[i];
      if (node.parentId) {
        permissions[map[node.parentId]].children[node.code] = node;
      } else {
        roots[node.code] = node;
      }
    }

    let modules = Object.keys(roots);
    modulesLoop:
    for (let i = 0; i < modules.length; i++) {
      let screens = Object.keys(roots[modules[i]]['children']);
      let moduleKey = modules[i];
      screenLoop:
      for (let j = 0; j < screens.length; j++) {
       let screenKey = screens[j];
        if (Object.entries(roots[moduleKey]['children'][screenKey]['children']).length == 0) {
          delete roots[moduleKey]['children'][screenKey];
          //break screenLoop;
        }
      }
      if (Object.entries(roots[moduleKey]['children']).length == 0) {
        delete roots[moduleKey];
        //break screenLoop;
      }
    }

    console.log(roots);

    this.permissions = roots;

  }
}

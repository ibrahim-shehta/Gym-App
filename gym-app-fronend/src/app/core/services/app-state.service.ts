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

    console.log({...roots});
    let modules = Object.keys(roots);
    for (let i = 0; i < modules.length; i++) {
      let screens = Object.keys(roots[modules[i]]['children']);
      for (let j = 0; j < screens.length; j++) {
        //console.log((roots[modules[i]]['children'][screens[j]]));
       // console.log((roots[modules[i]]['children'][screens[j]]['children']));
        // if (Object.keys(roots[modules[i]]['children'][screens[j]]['children']).length == 0) {
        //   delete roots[modules[i]];
        // }
      }
    }

    console.log(roots);

    this.permissions = roots;

  }
}

import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppStateService {

  profileImage = new BehaviorSubject<string>(null);
  constructor() { }

  changeProfileImage(image) {
    console.log('----------> ', image);
    this.profileImage.next(image);
  }
}

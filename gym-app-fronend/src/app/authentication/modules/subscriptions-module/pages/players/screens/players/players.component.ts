import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { PlayerList } from 'src/app/core/model/User';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlayersService } from '../../services/players.service';
@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent extends BaseTableComponent<PlayerList> implements OnInit, OnDestroy {

  constructor(
    public router: Router,
    public activatedRoute: ActivatedRoute,
    public notificationService: NotificationService,
    public translateService :TranslateService,
    public playersService: PlayersService
  ) {
    super(router, activatedRoute, notificationService, translateService);
   }

   ngOnInit() :void  {
    this.baseInit();
  }

  onClickAttendace(id) {
      this.resetState = false;
      this.router.navigate([AuthURL.Attendance], {relativeTo: this.activatedRoute, state: {id: id}});
  }
  getService() :PlayersService {
    return this.playersService;
  }

  getFilterArr() {
    return ["name", "username", "email", "mobile"]
  }

  ngOnDestroy() {
    super.onDestroy();
  }
}

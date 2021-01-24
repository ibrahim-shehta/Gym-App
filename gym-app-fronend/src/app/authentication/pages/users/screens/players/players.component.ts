import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseTableComponent } from 'src/app/core/model/BaseTableComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlayersService } from '../../services/players.service';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent extends BaseTableComponent implements OnInit {

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

  getService() :PlayersService {
    return this.playersService;
  }

  getFormUrl() :string {
    return AuthURL.PlayersForm;
  }
}

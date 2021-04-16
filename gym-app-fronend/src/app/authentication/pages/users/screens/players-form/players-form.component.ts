import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Player } from '../../model/User';
import { PlayersService } from '../../services/players.service';

@Component({
  selector: 'app-players-form',
  templateUrl: './players-form.component.html',
  styleUrls: ['./players-form.component.scss']
})
export class PlayersFormComponent extends BaseFormCompnent<Player> implements OnInit {
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private playersService :PlayersService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Player();
  }

  ngOnInit() :void {
    this.modeInit();
  }

  getService() :PlayersService {
    return this.playersService;
  }
}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthURL } from 'src/app/authentication/authentication.url';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PlayersService } from '../../services/players.service';

@Component({
  selector: 'app-players-form',
  templateUrl: './players-form.component.html',
  styleUrls: ['./players-form.component.scss']
})
export class PlayersFormComponent extends BaseFormCompnent implements OnInit {
  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private playersService :PlayersService,
  ) {
        super(router, activatedRoute, notificationService, translateService);
  }

  ngOnInit() :void {
    this.modeInit();
  }

  getService() :PlayersService {
    return this.playersService;
  }
}

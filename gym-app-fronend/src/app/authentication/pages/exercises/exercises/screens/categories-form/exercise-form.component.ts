import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Equipment } from 'src/app/authentication/pages/equipment/models/Equipment';
import { FilesTypes } from 'src/app/core/constants/files-types-enum';
import { BaseFormCompnent } from 'src/app/core/model/BaseFormComponent';
import { NotificationService } from 'src/app/core/services/notification.service';
import { environment } from 'src/environments/environment';
import { BaseExcerciseCategory } from '../../../categories/model/ExcerciseCategory';
import { Exercise } from '../../models/Exercise';
import { ExerciseService } from '../../services/exercise-service';


@Component({
  templateUrl: './exercise-form.component.html',
  styleUrls: ['./exercise-form.component.scss']
})
export class ExerciseFormComponent extends BaseFormCompnent<Exercise> implements OnInit {

  categories: [] = [];
  equipments: [] = [];

  filestypes = FilesTypes;
  progressImage;
  messageImage;
  progressVideo;
  messageVideo;
  imageUrl;
  videoUrl;
  imageFile;
  videoFile;



  constructor(
    public notificationService :NotificationService,
    public router :Router,
    public activatedRoute :ActivatedRoute,
    public translateService :TranslateService,
    private exerciseService :ExerciseService
  ) {
        super(router, activatedRoute, notificationService, translateService);
        this.entity = new Exercise();

  }

  ngOnInit() :void {
    this.entity = new Exercise();
    this.entity.category = new BaseExcerciseCategory();
    this.entity.equipment = new Equipment();
    this.modeInit();
  }

  getResolverData() {
    this.categories = this.activatedRoute.snapshot.data.form.categories.data;
    this.equipments = this.activatedRoute.snapshot.data.form.equipments.data;
    if (this.activatedRoute.snapshot.data.form.entity) {
      this.entity = this.activatedRoute.snapshot.data.form.entity.data;
      this.isEditMode = true;
      this.imageUrl = this.entity.imagePath ? environment.baseFilesesUrl + '/exercise/imgs/' + this.entity.imagePath : null;
      this.videoUrl = this.entity.vedioPath ? environment.baseFilesesUrl + '/exercise/videos/' + this.entity.vedioPath : null;
    }
  }


  onSelectFileEventImageHandler(e) {
    this.imageFile = e;
  }

  onSelectFileEventVideoHandler(e) {
    this.videoFile = e;
  }

  afterSave() {
    this.onSaveSelectedImageHandler(this.imageFile);
  }

  onSaveSelectedImageHandler(e) {
      if (!e) {
          this.onSaveSelectedVideoHandler(this.videoFile);
          return;
      }
      this.exerciseService.uploadFile(e, this.entity.id).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progressImage = Math.round(100 * event.loaded / event.total);
        if (this.progressImage > 0)
          this.messageImage = this.translateService.instant('COMMON.UPLOAD_SUCCESS');
      } else if (event instanceof HttpResponse) {
        this.entity.imagePath = event.body.data.imagePath;
        setTimeout(() => {
          this.progressImage = 0;
          this.messageImage = null;
        }, 1000);
      }
    },
    err => {
      this.progressImage = 0;
      this.backendError(err.error);
      this.messageImage = this.translateService.instant('COMMON.UPLOAD_FAIL');
    }, () => {
      if (!this.isEditMode) {
        this.onSaveSelectedVideoHandler(this.videoFile);
      }
    })
  }

  onSaveSelectedVideoHandler(e) {
    if (!e) {
      this.showSuccessMessageAndBack();
      return;
    }
    this.exerciseService.uploadFile(e, this.entity.id).subscribe(event => {
    if (event.type === HttpEventType.UploadProgress) {
      this.progressVideo = Math.round(100 * event.loaded / event.total);
      if (this.progressVideo == 100)
        this.messageVideo = this.translateService.instant('COMMON.UPLOAD_SUCCESS');
    } else if (event instanceof HttpResponse) {
      this.entity.vedioPath = event.body.data.vedioPath;
      setTimeout(() => {
        this.progressVideo = 0;
        this.messageVideo = null;
      }, 1000);
    }
  },
  err => {
    this.progressVideo = 0;
    this.backendError(err.error);
    this.messageVideo = this.translateService.instant('COMMON.UPLOAD_FAIL');
  }, () => {
    if (!this.isEditMode) {
      this.showSuccessMessageAndBack();
    }
    })
}

  getService() :ExerciseService {
    return this.exerciseService;
  }

}

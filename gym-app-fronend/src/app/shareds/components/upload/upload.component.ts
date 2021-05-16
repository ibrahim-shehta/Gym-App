import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FilesTypes } from 'src/app/core/constants/files-types-enum';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  progressValue;
  @Input() fileUrl;
  @Input() accept :string;
  @Input() fileType :FilesTypes = FilesTypes.IMAGE;
  @Input() message :string;
  @Input() set progress(val :number) {
    this.progressValue = val;
    if (val == 100) {
      this.isFileSelected = false;
    }
  };
  @Input() isEditMode: boolean;

  @Output() selectFileEvent = new EventEmitter<any>();
  @Output() saveSelectedFileEvent = new EventEmitter<any>();

  selectedFile;
  filesTypes = FilesTypes;
  isFileSelected: boolean;

  imageFile;

  constructor() { }

  ngOnInit(): void {
  }

  onFileChanged(event) {
    if (!event.target.files && !event.target.files[0]) {
      return;
    }
    this.selectedFile = event.target.files[0];
    const reader = new FileReader;
    reader.readAsDataURL(this.selectedFile);
    this.isFileSelected = true;
    reader.onload = (event :any) => {
      this.fileUrl = (<FileReader>event.target).result;
    }
    this.selectFileEvent.emit(this.selectedFile);
  }

  onSaveSelectedFile() {
    this.saveSelectedFileEvent.emit(this.selectedFile);
  }

}

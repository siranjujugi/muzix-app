import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Track } from '../../track';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  track : Track;

  @Input()
  wishData: boolean;

  @Output()
  addToWishList = new EventEmitter();

  @Output()
  updateComment = new EventEmitter();

  @Output()
  deleteFromWishList = new EventEmitter();

  constructor(private dialog : MatDialog) { }

  addButtonClick(track: Track) {
    console.log('emittedTrack from add' , track);
    this.addToWishList.emit(track);

  }

  deleteButtonClick(track : Track) {
    console.log('emittedTrack from delete' , track);
    this.deleteFromWishList.emit(track);
  }

  updateComments(){
    // DialogComponent
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: {comments : this.track.comments }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Comment result ', result);
      this.track.comments = result;
      this.updateComment.emit(this.track);
    });

  }

  ngOnInit() {
    console.log('WishData', this.wishData);
  }

}

import { Component, OnInit } from '@angular/core';
import { MuzixService } from '../../muzix.service';
import { Track } from '../../track';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

  tracks: Track[];
  wishData: boolean;
  statusCode: number;


  constructor(private muzixService: MuzixService, private snackBar: MatSnackBar) {
    this.wishData = true;
  }

  ngOnInit() {
    const message = "WishList is empty";
    this.muzixService.getAllTrackFromWishList().subscribe(data => {
      this.tracks = data;
      if (data.length === 0) {
        this.snackBar.open(message, "", { duration: 1000 });
      }
    });
  }

  deleteFromWishList(track: Track) {
    this.muzixService.deleteFromWishList(track).subscribe(data => {
      const index = this.tracks.indexOf(track);

      // console.log('Index size' , index);
      //To delete from screen right away
      this.tracks.splice(index, 1);
      this.snackBar.open("Track deleted from the user" , "", {
        duration: 1000
      });
    });
    // console.log('Remaining data', this.tracks);
    return this.tracks;
  }

  updateComment(track: Track) {
    this.muzixService.updateComment(track).subscribe(data => {
      console.log('Update response ', data);
      this.snackBar.open('Comment successfully updated !!', '', {
        duration: 1000
      });
    }, error => {
      console.log('error', error);
    }
    );
  }

}

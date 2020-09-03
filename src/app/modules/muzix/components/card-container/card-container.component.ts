import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Track } from '../../track';
import { Artist } from '../../artist';
import { Image } from '../../image';
import { MuzixService } from '../../muzix.service';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css']
})
export class CardContainerComponent implements OnInit {

  tracks: Track[];
  track: Track;
  artist: Artist;
  image: Image;
  countryName: string;
  id: number;
  statusCode: number;
  errorStatus: string;
  // wishData: false;
  artistName: string;
  searchTracks: Track[];


  constructor(private muzixService: MuzixService, private routes: ActivatedRoute, private matSnackBar: MatSnackBar) {
    this.tracks = [];

  }

  ngOnInit() {

    const tempData = this.routes.data.subscribe(iter => {
      this.countryName = iter.country;
      console.log('countryName', this.countryName);
    });

    this.muzixService.getTrackDetails(this.countryName).subscribe(tracks => {
      console.log(tracks);
      // Variable initialization for every iteration refresh
      this.id = 0;
      this.tracks = [];

      const data = tracks['tracks']['track'];

      this.tracks = [];
      data.forEach(element => {
        this.id++;
        this.track = new Track();
        this.artist = new Artist();
        this.image = new Image();

        this.artist = element["artist"];

        this.image.text = element["image"][2]["#text"];
        this.image.size = element["image"][2]["size"];

        this.track = element;
        this.track.artist = this.artist;
        this.artist.image = this.image;
        this.track.trackId = this.countryName.slice(0, 3) + this.id;

        this.tracks.push(this.track);
        this.searchTracks = this.tracks;

      });


    })
  }

  onKey(event : any) {
    this.artistName = event.target.value;
    //console.log('artistName', this.artistName);
    const result = this.searchTracks.filter( track => {
      return track.artist.name.match(this.artistName);
    });
    console.log('Filtered data', result);
    this.tracks = result;
  }

  addToWishList(track: Track) {
    console.log('Inside CardComponent', track);
    this.muzixService.addToWishList(track).subscribe(response => {
      console.log('Response', response)

      this.statusCode = response.status;
      if (this.statusCode === 201) {
        this.matSnackBar.open("Track successfully added !!", "", {
          duration: 1000
        })
      }
    }, 
    error => {
      this.errorStatus = `${error.status}`;
      const errorMsg = `${error.error.message}`;
      this.statusCode = parseInt(this.errorStatus, 10);
      if (this.statusCode === 409){
        this.matSnackBar.open(errorMsg, "", {
          duration : 1000
        });
        this.statusCode = 0;
      }

    }
    
    
    )
  }

}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Track } from './track';
import { USER_NAME } from '../authentication/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class MuzixService {

  thirdPartyApi: string;
  baseUrl: string;
  userName : string;
  apiKey: string;

  // getUrl : string;
  // deleteUrl : string;
  // putUrl : string;

  constructor(private httpClient: HttpClient) {
    this.apiKey = '&api_key=450de49dc8f6c9550cf1feadbd849972';
//    this.baseUrl='http://localhost:8085/api/v1/usertrackservice/user/';

    this.baseUrl='http://localhost:8089/usertrackservice/api/v1/usertrackservice/user/';

    this.thirdPartyApi = 'http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&format=json&country=';

    // this.getUrl="http://localhost:8083/api/v1/muzixservice/tracks";
    // this.deleteUrl="http://localhost:8083/api/v1/muzixservice/track/";
    // this.putUrl="http://localhost:8083/api/v1/muzixservice/track/";
  }

  getTrackDetails(country: String): Observable<any> {
    const url = `${this.thirdPartyApi}${country}${this.apiKey}`;
    return this.httpClient.get(url);

  }

  addToWishList(track: Track) {
    this.userName = sessionStorage.getItem(USER_NAME);
    const url = this.baseUrl + this.userName + "/track";
    return this.httpClient.post(url, track, {
      observe: "response"
    });
  }

  getAllTrackFromWishList(): Observable<Track[]>{
    this.userName = sessionStorage.getItem(USER_NAME);
    const url = this.baseUrl + this.userName + "/tracks";
    return this.httpClient.get<Track[]>(url);
  }

  deleteFromWishList(track : Track) {
    this.userName = sessionStorage.getItem(USER_NAME);
    const url = this.baseUrl  + this.userName + "/" + track.trackId;
    // const options = {
    //   headers : new HttpHeaders({
    //     'Content-Type' : 'application/json'
    //   }),
    //   body : track
    // } ;
    return this.httpClient.delete(url);
  }

  updateComment(track: Track) {
    this.userName = sessionStorage.getItem(USER_NAME);
    const url = this.baseUrl  + this.userName + "/track";
    return this.httpClient.patch(url, track, {observe : "response"});
  }

  filterArtists(tracks : Array<Track>, artistName : string) {
    const results = tracks.filter(track => {
      return track.artist.name.match(artistName);
    });
    return results;
  }

}
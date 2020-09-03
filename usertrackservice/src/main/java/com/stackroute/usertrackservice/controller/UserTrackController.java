/**
 * 
 */
package com.stackroute.usertrackservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.usertrackservice.domain.Track;
import com.stackroute.usertrackservice.domain.User;
import com.stackroute.usertrackservice.exception.TrackAlreadyExistsException;
import com.stackroute.usertrackservice.exception.TrackNotFoundException;
import com.stackroute.usertrackservice.exception.UserAlreadyExistsException;
import com.stackroute.usertrackservice.exception.UserNotFoundException;
import com.stackroute.usertrackservice.repository.UserTrackRepository;
import com.stackroute.usertrackservice.service.UserTrackService;

/**
 * @author siranjeevi
 *
 */
@RestController
@RequestMapping("/api/v1/usertrackservice")
//@CrossOrigin("*")
public class UserTrackController {
	
	
	@Autowired
	private UserTrackService service;

	
	@PostMapping("user/{userName}/track")
	@ExceptionHandler(TrackAlreadyExistsException.class)
	public ResponseEntity<?> saveUserTrackToWishList(@RequestBody Track track, @PathVariable("userName") String userName) throws TrackAlreadyExistsException {

		try {
			User result = service.saveUserTrackToWishList(track, userName);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (TrackAlreadyExistsException te) {
			throw new TrackAlreadyExistsException();
		} catch (Exception e) {
			return constructInternalServerException(e);
		}

	}

	@DeleteMapping("user/{userName}/{trackId}")
	public ResponseEntity<?> deleteUserTrackFromWishList(@PathVariable("userName") String userName, @PathVariable("trackId") String trackId ) throws TrackNotFoundException {

		try {
			User result = service.deleteUserTrackFromWishList(userName, trackId);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (TrackNotFoundException te) {
			throw new TrackNotFoundException();
		} catch (Exception e) {
			return constructInternalServerException(e);
		}

	}

	@PatchMapping("user/{userName}/track")
	public ResponseEntity<?> updateCommentForTrack(@RequestBody Track track, @PathVariable("userName") String userName) throws TrackNotFoundException {

		try {
			User result = service.updateCommentForTrack(track.getComments(), track.getTrackId(), userName);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (TrackNotFoundException te) {
			throw new TrackNotFoundException();
		} catch (Exception e) {
			return constructInternalServerException(e);
		}
	}

	@GetMapping("user/{userName}/tracks")	
	public ResponseEntity<?>  getAllUserTrackFromWishList(@PathVariable("userName") String userName) throws UserNotFoundException {
		try {
			List<Track> result = service.getAllUserTrackFromWishList(userName);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return constructInternalServerException(e);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {

		try {
			User result = service.registerUser(user);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (UserAlreadyExistsException te) {
			throw new UserAlreadyExistsException();
		} 
	}
	
	//TODO Move it to common class/utilities
		private ResponseEntity<?> constructInternalServerException(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

}

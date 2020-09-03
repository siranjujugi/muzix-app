/**
 * 
 */
package com.stackroute.usertrackservice.service;

import java.util.List;

import com.stackroute.usertrackservice.domain.Track;
import com.stackroute.usertrackservice.domain.User;
import com.stackroute.usertrackservice.exception.TrackAlreadyExistsException;
import com.stackroute.usertrackservice.exception.TrackNotFoundException;
import com.stackroute.usertrackservice.exception.UserAlreadyExistsException;

/**
 * @author sm211q
 *
 */
public interface UserTrackService {

	public User saveUserTrackToWishList(Track track, String userName) throws TrackAlreadyExistsException;
	public User deleteUserTrackFromWishList(String userName, String trackId) throws TrackNotFoundException;
	public User updateCommentForTrack(String comments, String trackId, String userName) throws TrackNotFoundException;
	public List<Track> getAllUserTrackFromWishList(String userName) throws Exception;
	public User registerUser(User user) throws UserAlreadyExistsException;

}

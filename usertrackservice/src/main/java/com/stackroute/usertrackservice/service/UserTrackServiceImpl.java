/**
 * 
 */
package com.stackroute.usertrackservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.usertrackservice.config.Producer;
import com.stackroute.usertrackservice.domain.Track;
import com.stackroute.usertrackservice.domain.User;
import com.stackroute.usertrackservice.exception.TrackAlreadyExistsException;
import com.stackroute.usertrackservice.exception.TrackNotFoundException;
import com.stackroute.usertrackservice.exception.UserAlreadyExistsException;
import com.stackroute.usertrackservice.exception.UserNotFoundException;
import com.stackroute.usertrackservice.rabbitmq.domain.UserDTO;
import com.stackroute.usertrackservice.repository.UserTrackRepository;

/**
 * @author sm211q
 *
 */
@Service
public class UserTrackServiceImpl implements UserTrackService {

	@Autowired
	private Producer producer;

	@Autowired
	private UserTrackRepository repo;

	@Override
	public User saveUserTrackToWishList(Track track, String userName) throws TrackAlreadyExistsException {

		User obj = repo.findByUserName(userName);
		List<Track> tracks = obj.getTracks();
		if (tracks != null) {
			for (Track iter : tracks) {
				if (track.getTrackId().equalsIgnoreCase(iter.getTrackId()))
					throw new TrackAlreadyExistsException();
			}
			tracks.add(track);
			obj.setTracks(tracks);
			producer.sendTrackMessage(constructDTO(obj, tracks));
			return repo.save(obj);
		} else {
			tracks = new ArrayList<Track>();
			tracks.add(track);
			obj.setTracks(tracks);
			producer.sendTrackMessage(constructDTO(obj, tracks));
			return repo.save(obj);
		}

	}

	private UserDTO constructDTO(User user, List<Track> tracks) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setUserName(user.getUserName());
		userDTO.setTracks(tracks);
		return userDTO;

	}

	@Override
	public User deleteUserTrackFromWishList(String userName, String trackId) throws TrackNotFoundException {

		User obj = repo.findByUserName(userName);
		List<Track> tracks = obj.getTracks();
		if (tracks != null) {
			Track result = tracks.stream().filter(i -> i.getTrackId().equalsIgnoreCase(trackId)).findFirst()
					.orElse(null);

			if (result != null) {
				tracks.remove(result);
				obj = repo.save(obj);
				return obj;
			}

		}
		throw new TrackNotFoundException();

	}

	@Override
	public User updateCommentForTrack(String comments, String trackId, String userName) throws TrackNotFoundException {

		User obj = repo.findByUserName(userName);
		List<Track> tracks = obj.getTracks();
		if (tracks != null) {

			for (int i = 0; i < tracks.size(); i++) {
				if (tracks.get(i).getTrackId().equalsIgnoreCase(trackId)) {
					tracks.get(i).setComments(comments);
					obj = repo.save(obj);
					return obj;
				}
			}

		}

		throw new TrackNotFoundException();
	}

	@Override
	public List<Track> getAllUserTrackFromWishList(String userName) throws UserNotFoundException {
		User user = repo.findByUserName(userName);
		if (user != null)
			return user.getTracks();
		else
			throw new UserNotFoundException();
	}

	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {

		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setPassword(user.getPassword());

		User obj = repo.findByUserName(user.getUserName());
		if (obj != null)
			throw new UserAlreadyExistsException();
		else {
			repo.save(user);
			producer.sendMessage(userDTO);
		}
		return user;
	}

//	@Override
//	public User saveUserTrackToWishList(Track track, String userName) throws TrackAlreadyExistsException {
//		// TODO Need to add null check on input id/track object
//		Optional<Track> trackResult = repo.findById(track.getTrackId());
//		if (trackResult.isPresent())
//			throw new TrackAlreadyExistsException();
//		// To get the track after successful insertion
//		return repo.insert(track);
//	}
//
//	@Override
//	public boolean deleteTrackFromWishList(String id) throws TrackNotFoundException {
//
//		Optional<Track> trackResult = repo.findById(id);
//		if (!trackResult.isPresent())
//			throw new TrackNotFoundException();
//		repo.deleteById(id);
//		return true;
//	}
//
//	@Override
//	public Track updateCommentForTrack(String comments, String id) throws TrackNotFoundException {
//
//		Optional<Track> trackResult = repo.findById(id);
//		if (!trackResult.isPresent())
//			throw new TrackNotFoundException();
//
//		Track track = trackResult.get();
//		track.setComments(comments);
//		return repo.save(track);
//	}
//
//	@Override
//	public List<Track> getAllTrackFromWishList() throws Exception {
//		return repo.findAll();
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

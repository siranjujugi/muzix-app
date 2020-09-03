/**
 * 
 */
package com.stackroute.usertrackservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.usertrackservice.domain.User;

/**
 * @author siranjeevi
 *
 */
public interface UserTrackRepository extends MongoRepository<User, String> {

	public User findByUserName (String userName);
	
}

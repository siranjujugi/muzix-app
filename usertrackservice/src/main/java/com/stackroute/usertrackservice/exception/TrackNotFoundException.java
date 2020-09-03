/**
 * 
 */
package com.stackroute.usertrackservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sm211q
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Track with specified id is not found")
public class TrackNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

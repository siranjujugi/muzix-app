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

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Track already exists")
public class TrackAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

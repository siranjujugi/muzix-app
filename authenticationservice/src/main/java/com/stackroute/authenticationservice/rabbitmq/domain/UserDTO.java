/**
 * 
 */
package com.stackroute.authenticationservice.rabbitmq.domain;


/**
 * @author siranjeevi
 *
 */
public class UserDTO {
	
	private String userName;
	private String email;
	private String password;
	
//	private List<TrackDTO> tracks;
	
	public UserDTO() {
		
	}

	/**
	 * @param userName
	 * @param email
	 * @param tracks
	 */
	public UserDTO(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
//		this.tracks = tracks;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

//	/**
//	 * @return the tracks
//	 */
//	public List<TrackDTO> getTracks() {
//		return tracks;
//	}
//
//	/**
//	 * @param tracks the tracks to set
//	 */
//	public void setTracks(List<TrackDTO> tracks) {
//		this.tracks = tracks;
//	}


	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", tracks=" + tracks
//				+ "]";
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

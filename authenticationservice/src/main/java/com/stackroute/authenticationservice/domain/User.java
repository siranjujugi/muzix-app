/**
 * 
 */
package com.stackroute.authenticationservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author siranjeevi
 *
 */
@Entity
public class User {

	@Id @GeneratedValue
	private int userId;
	private String userName;
	private String password;
	
	public User() {
		//Default constructor
	}
	
	public User(int userId, String userName,String password ) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}

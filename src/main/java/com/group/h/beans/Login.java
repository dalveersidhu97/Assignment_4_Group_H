package com.group.h.beans;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description This is a bean class which store the user name and password of
 *              the User.
 * 
 */

public class Login {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	private String password;

}

package com.group.h.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.dao.UserDao;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description This class interact with userDao bean to provide a layer of
 *              abstraction.
 * 
 */

interface UserServiceInterface {
	int register(User user);

	User validateUser(Login login);
}

public class UserService implements UserServiceInterface {
	@Autowired
	public UserDao userDao;
	@Autowired
	public EncryptionService enService;

	public int register(User user) {

		// Encrypting password
		String encrypted = enService.encrypt(user.getPassword().trim());

		// return 0 row effected if could not encrypt password
		if (encrypted == null)
			return 0;

		user.setPassword(encrypted);

		return userDao.register(user);
	}

	public User validateUserToken(Login login) {
		return userDao.validateUser(login);
	}

	public User validateUser(Login login) {
		// encrypting to match with the encrypted password in database
		login.setPassword(enService.encrypt(login.getPassword()));
		return validateUserToken(login);
	}
}
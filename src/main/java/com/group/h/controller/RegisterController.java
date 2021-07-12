package com.group.h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.dao.UserDao;
import com.group.h.service.UserService;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description Controller for register path. Shows the register form, gets all
 *              the data and perform the registration shows error message if
 *              incorrect data is provided.
 * 
 */

@Controller
public class RegisterController {

	@Autowired
	UserService userService;

	@RequestMapping("/register")
	public String showRegisterForm(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String processRegisteration(@ModelAttribute("user") User user, Model m) {

		int i = userService.register(user);
		// check if one row is affected otherwise show error message
		if (i == 1) {
			
			m.addAttribute("message", "Resigtration Successfull! You can login now.");
			m.addAttribute("login", new Login());
			return "login";
			
		} else if (i == UserDao.USER_ALREADY_EXISTS)
			m.addAttribute("message", "User already exists!");
		
		else
			m.addAttribute("message", "Please enter correct data!");
		
		return "register";
	}

}

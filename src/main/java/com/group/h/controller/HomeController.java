package com.group.h.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.service.UserService;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description Controller class for root routes such as '/', '/welcome',
 *              '/logout'. It checks if the user is logged In and serves the
 *              profile page or login page accordingly.
 */

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String showHome(Model m, HttpServletRequest request) {

		User u = isLoggedIn(request);
		if (u != null) {
			m.addAttribute("user", u);
			return "welcome";
		}
		return "home";
	}
	@RequestMapping("/welcome")
	public String welcome(Model m, HttpServletRequest request) {

		User u = isLoggedIn(request);
		if (u != null) {
			m.addAttribute("user", u);
			return "welcome";
		}
		m.addAttribute("message", "Please login first!");
		m.addAttribute("login", new Login());
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(Model m, HttpServletResponse response) {

		Cookie username = new Cookie("username", "");
		username.setMaxAge(0);
		Cookie token = new Cookie("token", "");
		token.setMaxAge(0);
		response.addCookie(username);
		response.addCookie(token);
		return "redirect:/";
	}
	// return User object if user is logged in otherwise returns null
	private User isLoggedIn(HttpServletRequest request) {
		String username = "", password="";
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("username"))
				username = cookie.getValue();
			if (cookie.getName().equals("token"))
				password = cookie.getValue();
		}
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		return userService.validateUserToken(login);
	}

}

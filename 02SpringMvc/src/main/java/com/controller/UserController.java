package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@RequestParam("username")String username , @RequestParam("password")String password) {

			System.out.println(username);
			System.out.println(password);
		//if ("aaa".equals(username) && "111".equals(password)) {
			if(userService.checklogin(username,password)) {
			return "loginsuccess";
			
		
		}else{
			return "loginFail";
		}
	
	
   }

	//@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		userService.addUser(username, password);
		// TODO:
		return "loginsuccess";
	}
}

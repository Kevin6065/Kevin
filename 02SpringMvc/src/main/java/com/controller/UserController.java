package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String login(@RequestParam("username")String username , @RequestParam("password")String password) {

			System.out.println(username);
			System.out.println(password);
		if ("aaa".equals(username) && "111".equals(password)) {
			return "loginsuccess";
			
		
		}else{
			return "loginFail";
		}
	
	
   }
}

package com.gep.login.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gep.login.dao.LoginRepository;
import com.gep.login.entities.UserLogin;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/index")
	public String dashboard(Model model,Principal principal) {
		String userName=principal.getName();
		System.out.println("Username="+userName);
		
		UserLogin user=this.loginRepository.getUserByUserName(userName);
		//System.out.println("User="+user);
		model.addAttribute("user", user);
		return "normal/user_dashboard";
	}

}

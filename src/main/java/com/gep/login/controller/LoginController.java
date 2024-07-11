package com.gep.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gep.login.dao.LoginRepository;
import com.gep.login.entities.UserLogin;
import com.gep.login.helper.Message;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private LoginRepository loginRepository;
	
//	@GetMapping("/login")
//	@ResponseBody
//	public String test() {
//		UserLogin user=new UserLogin();
//		user.setUser_Name("geplogin");
//		user.setPassword("gep@login");
//		loginRepository.save(user);
//		return "Working...";
//	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title","Login Page");
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup( Model model) {
		model.addAttribute("user", new UserLogin());
		return "signup";
	}
	
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") UserLogin user,Model model,HttpSession session) {
		try {
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			this.loginRepository.save(user);
			model.addAttribute("user", new UserLogin());
			session.setAttribute("message", new Message("Successfully registered", "alert-success"));
			return "signup";
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(), "alert-danger"));
			return "signup";
		}
		
		
	}


}

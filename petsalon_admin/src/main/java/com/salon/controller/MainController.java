package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("path", "home/home_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "login_index";
	}
/*	
	@RequestMapping("/")
	public String login_index() {
		return "login_index";	
	}
	
*/	

}

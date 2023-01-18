package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService uservice;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("session", session);
		return "index";
	}
	@RequestMapping("/lostinfo")
	public String lostinfo() {
		return "lostinfo";
	}
}

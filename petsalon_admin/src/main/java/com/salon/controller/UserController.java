package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.User;
import com.salon.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	String dir = "user/";
	
	@RequestMapping("/users")
	public String usermain(Model model) {
		List<User> list = null;
		try {	
		list = userservice.get();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",list);
		model.addAttribute("path",dir+"user_main");
		model.addAttribute("content","main");
		return "main";
	}
	
	/* 임시 확인용
	@RequestMapping("/userlist")
	public String userlist(Model model) {
		List<User> list = null;
		try {	
		list = userservice.get();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",list);
		return "userlist_temp";
	}
	*/
}

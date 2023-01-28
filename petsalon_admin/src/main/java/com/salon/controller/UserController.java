package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.User;
import com.salon.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	String dir = "user/";
	
	@RequestMapping("/users")
	public String usermain(Model model) {
		List<User> ulist = null;
		try {	
		ulist = userservice.get();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",ulist);
		model.addAttribute("path",dir+"member");
		model.addAttribute("content","main");
		return "main";
	}
	
	@RequestMapping("/usersearch")
	public String usersearch(Model model, String searchValue) {
		List<User> ulist = null;
		try {	
		ulist = userservice.usersearch(searchValue);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",ulist);
		model.addAttribute("path",dir+"member");
		model.addAttribute("content","main");
		return "main";
	}
	
	@RequestMapping("/uDelete")
	public String delete(Model model, String delEmail) {
		
		System.out.println(delEmail);
		try {
			userservice.remove(delEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/users";
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

package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@Controller
public class MainController {

	@Autowired
	ResvService rservice;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		List<Resv> rlist;
		try {
			rlist = rservice.notFixed();
			model.addAttribute("checkresv",rlist.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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

package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.dto.Review;
import com.salon.service.ResvService;
import com.salon.service.ReviewService;

@Controller
public class MainController {

	@Autowired
	ResvService rservice;
	
	@Autowired
	ReviewService rvservice;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		List<Resv> rlist;
		List<Review> rvlist;
		
		try {
			rlist = rservice.notFixed();
			rvlist = rvservice.onedayReivew();
			model.addAttribute("checkresv",rlist.size());
			model.addAttribute("checkreview",rvlist.size());
			
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

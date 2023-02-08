package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.service.ResvService;

@Controller
public class MyPageController {
	@Autowired
	ResvService rservice;
	
	@RequestMapping("/mypage")
	public String myresv(HttpSession session, Model model) {
		String useremail = (String) session.getAttribute("logemail");
		try {
			model.addAttribute("resv",rservice.userResv(useremail));
			model.addAttribute("resvdel",rservice.resvdelchk(useremail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
}

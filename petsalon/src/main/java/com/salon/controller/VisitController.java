package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.service.ResvService;

@Controller
public class VisitController {
	@Autowired
	ResvService rservice;
	
	String dir = "visit/";
	
	@RequestMapping("/visit")
	public String visit(HttpSession session, Model model) {
		String useremail = (String) session.getAttribute("logemail");
		try {
			model.addAttribute("visit",rservice.visit(useremail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "mypage";
	}
}

package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	String dir = "review/";
	
	@RequestMapping("/review")
	public String main(Model model) {
		model.addAttribute("path", dir+"review_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
}

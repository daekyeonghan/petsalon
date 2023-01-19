package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	
	String reviewdir = "review/";
	
	@RequestMapping("/reviewmain")
	public String main(Model model) {
		model.addAttribute("center", reviewdir+"reviewmain");
		return "index";
	}

}

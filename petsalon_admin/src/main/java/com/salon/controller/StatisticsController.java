package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

	String dir = "statistics/";
	
	@RequestMapping("/statistics")
	public String main(Model model) {
		model.addAttribute("path", dir+"statistics_main");
		model.addAttribute("content", "main");
		return "main";
	}
}

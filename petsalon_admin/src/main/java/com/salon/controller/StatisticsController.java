package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

	String dir = "statistics/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("path", dir+"statistics_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
	
	@RequestMapping("/userdog")
	public String userdog(Model model) {
		model.addAttribute("path", dir+"statistics_userdog");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/styles")
	public String styles(Model model) {
		model.addAttribute("path", dir+"statistics_item");
		model.addAttribute("content", "main");
		return "main";
	}
}

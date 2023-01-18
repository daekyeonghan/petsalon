package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

	String dir = "item/";
	
	@RequestMapping("/item")
	public String main(Model model) {
		model.addAttribute("path", dir+"item_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
}

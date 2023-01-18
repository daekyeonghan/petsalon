package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

	String dir = "shop/";
	
	@RequestMapping("/shop")
	public String main(Model model) {
		model.addAttribute("path", dir+"shop_main");
		model.addAttribute("content", "main");
		return "main";
	}
}

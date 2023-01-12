package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about.html")
public class AboutController {	
	@RequestMapping("")
	public String main() {
		return "about";
	}
}

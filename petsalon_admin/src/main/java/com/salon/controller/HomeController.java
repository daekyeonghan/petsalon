package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


@RequestMapping("/homeerror")
public String error(Model model) {
	model.addAttribute("path", "fragments");
	model.addAttribute("content", "fail");
	return "main";
}
}

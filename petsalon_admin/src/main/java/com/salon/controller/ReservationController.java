package com.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {

	String dir = "reservation/";
	
	@RequestMapping("/reservation")
	public String main(Model model) {
		model.addAttribute("path", dir+"reservation_main");
		model.addAttribute("content", "main");
		return "main";
	}
}

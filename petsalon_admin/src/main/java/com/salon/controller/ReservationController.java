package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@Controller
public class ReservationController {

	String dir = "reservation/";
	
	@Autowired
	ResvService rservice;
	
	@RequestMapping("/reservation")
	public String main(Model model) {
		
		List<Resv> rlist = null;
		
		try {
			rlist = rservice.selectlist();
			model.addAttribute("rlist",rlist);
			
			model.addAttribute("path", dir+"reservation_main");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
		
		return "main";
	}
}

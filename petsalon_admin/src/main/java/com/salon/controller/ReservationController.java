package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;

@Controller
public class ReservationController {

	String dir = "reservation/";
	
	@Autowired
	ResvService rservice;
	
	@Autowired
	ScheduleService schservice;
	
	@RequestMapping("/reservation")
	public String main(Model model) {
		
		List<Resv> rlist = null;
		
		try {
			rlist = rservice.scheduleList();
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
	
	
	@RequestMapping("/resvFix")
	public String resvFix(int no, int fix) {
		
		try {
			rservice.resvFixUpdate(no, fix);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/reservation";
		
	}
	
}

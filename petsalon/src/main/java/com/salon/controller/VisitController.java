package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@Controller
public class VisitController {
	@Autowired
	ResvService rservice;
	
	String dir = "visit/";
	
	@RequestMapping("/visit")
	public String visit(HttpSession session, Model model) {
		String useremail = (String) session.getAttribute("logemail");
		
		try {
			List<Resv> list = rservice.reviewvisit(useremail);
			List<Resv> noreview = rservice.reviewvisitcheck(useremail);

			if(list.isEmpty()) {
				model.addAttribute("novisit",1);
			}else {
				model.addAttribute("visit",list);
				model.addAttribute("noreview",noreview);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "mypage";
	}
}

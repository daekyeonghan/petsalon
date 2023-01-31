package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.service.DesignerService;
import com.salon.service.DogService;
import com.salon.service.ItemService;

@Controller
public class ResvController {
	@Autowired
	DogService dogservice;
	@Autowired
	DesignerService deservice;
	@Autowired
	ItemService iservice;
	
	@RequestMapping("/resv")
	public String resv(Model model, HttpSession session) {
		String useremail = (String)session.getAttribute("logemail");
		try {
			model.addAttribute("dog", dogservice.ownerdog(useremail));
			model.addAttribute("design",deservice.get());
			model.addAttribute("item", iservice.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "resv";
	}
}

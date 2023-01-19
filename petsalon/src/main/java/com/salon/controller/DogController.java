package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Dog;
import com.salon.service.DogService;

@Controller
@RequestMapping("/doginfo")
public class DogController {
	@Autowired
	DogService service;
	
	String dir = "doginfo/";
	
	@RequestMapping("")
	public String doginfo(HttpSession session, Model model) {
		String useremail = (String)session.getAttribute("logemail");
		Dog dog = null;
		try {
			dog = service.ownerdog(useremail);
			model.addAttribute("dog", dog);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center", dir+"center");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
}

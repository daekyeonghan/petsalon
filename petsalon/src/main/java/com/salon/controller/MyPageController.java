package com.salon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Dog;
import com.salon.dto.User;
import com.salon.service.DogService;
import com.salon.service.ResvService;
import com.salon.service.UserService;

@Controller
public class MyPageController {
	@Autowired
	ResvService rservice;
	
	@RequestMapping("/mypage")
	public String myresv(HttpSession session, Model model) {
		String useremail = (String) session.getAttribute("logemail");
		try {
			model.addAttribute("resv",rservice.userResv(useremail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
}

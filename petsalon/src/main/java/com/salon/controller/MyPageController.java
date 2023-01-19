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
import com.salon.service.UserService;

@Controller
public class MyPageController {
	@Autowired
	UserService uservice;
	DogService dservice;
	
	@RequestMapping("/mypage")
	public String userinfo(HttpSession session, Model model) {
		String useremail = (String)session.getAttribute("logemail");
		User user = null;
		try {
			user = uservice.get(useremail);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/updateuser")
	public String updateuser(HttpServletRequest req, HttpSession session) {
		User user = new User();
		user.setUseremail((String)session.getAttribute("logemail"));
		user.setUsername(req.getParameter("username"));
		user.setTel(req.getParameter("tel"));
		user.setAddr(req.getParameter("addr"));
		user.setDetaddr(req.getParameter("detaddr"));
		user.setZipcode(req.getParameter("zipcode"));
		try {
			uservice.modify(user);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}

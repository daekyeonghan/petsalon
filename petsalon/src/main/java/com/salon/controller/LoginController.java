package com.salon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salon.dto.User;
import com.salon.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService uservice;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginimpl")
	public ModelAndView loginimpl(HttpServletRequest req, HttpSession session, Model model, ModelAndView mav) {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		User user = null;
		try {
			user = uservice.get(email);
			if(user==null) {
				session.setAttribute("result", 1);
				mav.setViewName("redirect:login");
			}else {
				if(user.getUserpwd().equals(pwd)) {
					session.setAttribute("logemail", email);
					session.setAttribute("logname", user.getUsername());
					mav.setViewName("redirect:/");
				}else {
					session.setAttribute("result", 1);
					mav.setViewName("redirect:login");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("session", session);
		return "index";
	}
	
	@RequestMapping("/lostinfo")
	public String lostinfo() {
		return "lostinfo";
	}
}

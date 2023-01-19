package com.salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salon.dto.User;
import com.salon.service.UserService;

@Controller
public class RegisterController {
	
	String regidir = "register/";
	
	@Autowired
	UserService service;

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", regidir+"register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, User user) {
		String useremail = user.getUseremail();
		String userpwd = user.getUserpwd();
		String username = user.getUsername();
		String birth = user.getBirth();
		String tel = user.getTel();
		String addr = user.getAddr();
		String detaddr = user.getDetaddr();
		String zipcode = user.getZipcode();
		
		try {
			service.register(user);
			System.out.println("OK");
			model.addAttribute("name", user.getUsername());
			model.addAttribute("center",regidir+"registerok");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/checkid", method = {RequestMethod.GET})
	public @ResponseBody int idCheck(String useremail) {
		if(useremail == null || useremail == "") {
			return -1;
		}else {
			return service.checkId(useremail);
		}
	}
	
	


}

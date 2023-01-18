package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.User;
import com.salon.service.UserService;

@RestController
public class AjaxController {
	@Autowired
	UserService uservice;
	
	@RequestMapping("/loginimpl")
	public Object loginimpl(String email, String pwd, HttpSession session) {
		int result = 0;
		User user = null;
		try {
			user = uservice.get(email);
			if(user==null) {
				result=0;
			}else {
				if(user.getUserpwd().equals(pwd)) {
					result = 1;
					session.setAttribute("logemail", email);
					session.setAttribute("logpwd", pwd);
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("/findemail")
	public Object findemail(String username, String tel) {
		String useremail = null;
		try {
			useremail = uservice.findemail(username, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return useremail;
	}
	@RequestMapping("/findpwd")
	public Object findpwd(String useremail) {
		String pwd = null;
		try {
			pwd = uservice.findpwd(useremail);
			System.out.println(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
	@RequestMapping("/updateuser")
	public String updateuser(User user) {
		try {
			uservice.modify(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}

package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Admin;
import com.salon.service.AdminService;

@RestController
public class WKAjaxController {

	@Autowired
	AdminService adservice;
	
	@RequestMapping("/loginimpl")
	public Object loginimpl(String admin_id, String admin_pwd, HttpSession session) {
		int result = 0;

		Admin admin = null;
		try {
			admin = adservice.get(admin_id);
			if (admin == null) {
				result = 0;
			} else {
				if (admin.getAdmin_pwd().equals(admin_pwd)) {
					System.out.println(admin_id);
					result = 1;
					session.setAttribute("logemail",admin_id);
					session.setAttribute("logpwd", admin_pwd);
				} else
					result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

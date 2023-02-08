package com.salon.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salon.dto.Admin;
import com.salon.service.AdminService;

@Controller
public class MainController {


	
	@Autowired
	AdminService adservice;
	
	
	
	@RequestMapping("/")
	public String login(HttpSession session) {
		
		if(session != null) {
			session.removeAttribute("admin");
			
		}
		
		return "login_index";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
		return "login_index";
	}
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpServletRequest req, HttpSession session, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String admin_id = req.getParameter("admin_id");
		String admin_pwd = req.getParameter("admin_pwd");
		
		
		/* String enc_plainText = CryptoUtil.sha512(pwd); */
		
		Admin admin = null;
		try {
			admin = adservice.get(admin_id);
			if(admin==null) {
				session.setAttribute("result", 1);
				return "redirect:/";
			}else {
				if(admin.getAdmin_pwd().equals(admin_pwd)) {
					session.setAttribute("admin", admin);
					return "redirect:/home";
				}else {
					session.setAttribute("result", 1);
					return "redirect:/";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/ERROR")
	public String authoError() {
		return "error/403";
	}


}

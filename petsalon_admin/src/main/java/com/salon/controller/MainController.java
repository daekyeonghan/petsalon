package com.salon.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Admin;
import com.salon.dto.User;
import com.salon.frame.CryptoUtil;
import com.salon.service.AdminService;

@Controller
public class MainController {


	
	@Autowired
	AdminService adservice;
	
	
	
	@RequestMapping("/")
	public String login(HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
		
		return "login_index";
	}
	
	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		if(session != null) {
//			session.invalidate();
//		}
//		return "login_index";
//	}
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpServletRequest req, HttpSession session, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String admin_id = req.getParameter("admin_id");
		String admin_pwd = req.getParameter("admin_pwd");
		
		
		/* String enc_plainText = CryptoUtil.sha512(pwd); */
		
		String enc_plainText = CryptoUtil.sha512(admin_pwd);
		
		Admin admin = null;
		try {
			admin = adservice.get(admin_id);
			if(admin==null) {
			//	session.setAttribute("result", 1);
				return "redirect:/";
			}else {
				if(admin.getAdmin_pwd().equals(enc_plainText)||admin.getAdmin_pwd().equals(admin_pwd)) {
					session.setAttribute("admin", admin);
					return "redirect:/home";
				}else {
			//		session.setAttribute("result", 1);
					return "redirect:/";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/pwd")
	public String pwd(Model model, Admin admin) {
		model.addAttribute("path", "home/pwd_setting");
		model.addAttribute("content", "main");
		return "main";
	}
	
	
	@RequestMapping("/pwdmodify")
	public String pwdmodify(Model model, Admin admin) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String adminPwd = admin.getAdmin_pwd();
		String enc_adminPwd = CryptoUtil.sha512(adminPwd);
		
		admin.setAdmin_pwd(enc_adminPwd);
		try {
			adservice.modify(admin);
			return "redirect:/home";
		} catch (Exception e) {
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			e.printStackTrace();
		}
		
		return "main";
	}
	

	@RequestMapping("/ERROR")
	public String errorForbidden(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return "error/403";
	}
	
}

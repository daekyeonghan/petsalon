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

import com.salon.dto.User;
import com.salon.frame.CryptoUtil;
import com.salon.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService uservice;
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest req) {
		model.addAttribute("center", "login");
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public ModelAndView loginimpl(HttpServletRequest req, HttpSession session, Model model, ModelAndView mav) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		/*암호화 주석 없애야됨
		 * String enc_plainText = CryptoUtil.sha512(pwd);
		 * System.out.println(enc_plainText);
		 */

		User user = null;
		try {
			user = uservice.get(email);
			if(user==null) {
				mav.setViewName("redirect:login");
			}else {
				if(user.getUserpwd().equals(pwd)) { //암호화 주석 없애야됨 enc_plainText 랑 pwd랑 변경
					System.out.println("OK");
					session.setAttribute("logemail", email);
					session.setAttribute("logname", user.getUsername());
					session.setAttribute("logpwd", user.getUserpwd());
					mav.setViewName("redirect:/");
				}else {
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
}

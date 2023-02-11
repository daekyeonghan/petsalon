package com.salon.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salon.dto.User;
import com.salon.frame.CryptoUtil;
import com.salon.service.UserService;

@Controller
public class RegisterController {
	
	String regidir = "register/";
	
	@Autowired
	UserService service;

	@RequestMapping("/register")
	public String register(Model model)  {
		model.addAttribute("center", regidir+"register");
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, User user) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String useremail = user.getUseremail();
		String userpwd = user.getUserpwd();
		
		String enc_userpwd = CryptoUtil.sha512(userpwd);
		
		String username = user.getUsername();
		String birth = user.getBirth();
		String tel = user.getTel();
		String addr = user.getAddr();
		String detaddr = user.getDetaddr();
		String zipcode = user.getZipcode();
		
		user.setUserpwd(enc_userpwd);
		
		try {
			service.register(user);
			System.out.println("OK");
			model.addAttribute("name", user.getUsername());
			model.addAttribute("center",regidir+"registerok");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/checkid", method = {RequestMethod.GET})
	public @ResponseBody int idCheck(String useremail) {
		if(useremail == null || useremail == "") {
			return -1;
		}else {
			return service.checkId(useremail);
		}
	}
	
	@RequestMapping("/pwdmodify")
	public String pwdmodify(Model model, User user) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String useremail = user.getUseremail();
		String userpwd = user.getUserpwd();
		System.out.println(useremail);
		String enc_userpwd = CryptoUtil.sha512(userpwd);
		
		user.setUserpwd(enc_userpwd);
		System.out.println(enc_userpwd);
		try {
			service.resetpwd(enc_userpwd, useremail);
			System.out.println("OK");
			model.addAttribute("center",regidir+"pwdresetok");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
		return "main";
	}
	
	


}

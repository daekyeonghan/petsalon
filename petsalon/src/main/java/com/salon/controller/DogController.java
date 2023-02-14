package com.salon.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.salon.dto.Dog;
import com.salon.frame.Util;
import com.salon.service.DogService;

@Controller
public class DogController {
	@Autowired
	DogService dservice;
	
	@Value("${admindir}")
	String admindir;

	@Value("${userdir}")
	String userdir;
	
	String dir = "doginfo/";
	
	@RequestMapping("/doginfo")
	public String doginfo(HttpSession session, Model model) {
		String useremail = (String)session.getAttribute("logemail");
		List<Dog> dogList = null;
		try {
			dogList = dservice.ownerdog(useremail);
			if(dogList.isEmpty()) {
				model.addAttribute("nodogList", 1);
			}else {
				model.addAttribute("dogList", dogList);
			}
			model.addAttribute("left", dir+"left");
			model.addAttribute("content", dir+"content");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/updatedog")
	public String updatedog(HttpServletRequest req, Model model) {
		int dog_id = Integer.parseInt(req.getParameter("dog_id"));
		Dog dog = null;
		try {
			dog = dservice.get(dog_id);
			model.addAttribute("dog", dog);
			model.addAttribute("left", dir+"left");
			model.addAttribute("content", dir+"updatedog");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/updatedogOk")
	public String updateuser(HttpSession session, Model model, Dog dog, String originname) {
		String useremail = (String)session.getAttribute("logemail");
		String blankName = dog.getDog_img().getOriginalFilename();
		
		try {
			if(dog.getDog_img()!= null && blankName.length() != 0) {
				String newName = Util.saveFile(dog.getDog_img(), userdir, admindir);
				dog.setDog_photo(newName);
				dservice.modify(dog);
				Util.deleteFile(admindir, userdir, originname);
			}else {
				dservice.nopicUpdate(dog);
			}
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		try {
			model.addAttribute("dogList",dservice.ownerdog(useremail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("left", dir+"left");
		model.addAttribute("content", dir+"content");
		return "mypage";
	}
	@RequestMapping("/adddog")
	public String adddog(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("content", dir+"adddog");
		return "mypage";
	}
	@RequestMapping("/adddogOk")
	public String adddogOk(HttpSession session, Dog dog, Model model) {
		String useremail = (String)session.getAttribute("logemail");
		String img = dog.getDog_img().getOriginalFilename();
		
		try {
			if(dog.getDog_img()!=null && img.length()!=0) {
				String newName = Util.saveFile(dog.getDog_img(),admindir,userdir);
				dog.setDog_photo(newName);
			}
			else {
				dservice.nopicUpdate(dog);
				dog.setDog_photo("logo.svg");
			}
			dservice.register(dog);
			model.addAttribute("dogList",dservice.ownerdog(useremail));
			model.addAttribute("left",dir+"left");
			model.addAttribute("content",dir+"content");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/deletedog")
	public String deletedog(HttpSession session, Model model, Integer dog_id, String originname) {
		String useremail = (String)session.getAttribute("logemail");
		List list = null;
		try {
			dservice.remove(dog_id);
			if(!originname.equals("logo.svg")) {
				Util.deleteFile(admindir, userdir, originname);
			}
			list = dservice.ownerdog(useremail);
			model.addAttribute("dogList", list);
			model.addAttribute("left", dir+"left");
			model.addAttribute("content", dir+"content");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
}

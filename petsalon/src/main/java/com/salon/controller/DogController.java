package com.salon.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.salon.dto.Dog;
import com.salon.service.DogService;

@Controller
public class DogController {
	@Autowired
	DogService dservice;
	
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
			model.addAttribute("center", dir+"center");
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
			model.addAttribute("center", dir+"updatedog");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/updatedogOk")
	public String updateuser(HttpServletRequest req, HttpSession session, Model model) {
		Dog dog = new Dog();
		
		int dog_id = Integer.parseInt(req.getParameter("dog_id"));
		int dog_age = Integer.parseInt(req.getParameter("dog_age"));
		float dog_weight = Float.valueOf(req.getParameter("dog_weight"));
		
		String path = req.getSession().getServletContext().getRealPath("/");
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile file = mr.getFile("dog_photo");
		
		String fName = file.getOriginalFilename();
		if(file!=null) {
			if(fName!=null && !fName.equals("")) {
				File f = new File(path,fName);
				if(f.exists()) {
					for(int rename=1;;rename++) {
						int dot = fName.lastIndexOf(".");
						String fileNameNoExt = fName.substring(0,dot);
						String extend = fName.substring(dot);
						
						String newFileName = fileNameNoExt + "(" + rename + ")";
						
						f = new File(path,newFileName);
						if(!f.exists()) {
							fName = newFileName;
							break;
						}
					}
				}
			}
			try {
				file.transferTo(new File(path,fName));
				try {
					dog = dservice.get(dog_id);
					File f = new File(path,dog.getDog_photo());
					if(f.exists()) f.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dog.setDog_id(dog_id);
		dog.setDog_name(req.getParameter("dog_name"));
		dog.setDog_photo(fName);
		dog.setDog_gender(req.getParameter("dog_gender"));
		dog.setDog_age(dog_age);
		dog.setDog_weight(dog_weight);
		dog.setDog_breed(req.getParameter("dog_breed"));
		dog.setDog_special(req.getParameter("dog_special"));
		
		try {
			dservice.modify(dog);
			List<Dog> dogList = dservice.ownerdog((String)session.getAttribute("logemail"));
			model.addAttribute("dogList", dogList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "mypage";
	}
	@RequestMapping("/adddog")
	public String adddog(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"adddog");
		return "mypage";
	}
	@RequestMapping("/adddogOk")
	public String adddogOk(HttpServletRequest req, HttpSession session, Model model) {
		Dog dog = new Dog();
		
		int dog_age = Integer.parseInt(req.getParameter("dog_age"));
		float dog_weight = Float.valueOf(req.getParameter("dog_weight"));
		
		String path = req.getSession().getServletContext().getRealPath("/");
		MultipartHttpServletRequest ms = (MultipartHttpServletRequest)req;
		MultipartFile file = ms.getFile("dog_photo");
		
		String fName = file.getOriginalFilename();
		if(file!=null) {
			if(fName!=null && !fName.equals("")) {
				File f = new File(path,fName);
				if(f.exists()) {
					for(int rename=1;;rename++) {
						int dot = fName.lastIndexOf(".");
						String filenameNoExt = fName.substring(0,dot);
						String extend = fName.substring(dot);
						
						String newFilename = filenameNoExt + "(" + rename + ")" + extend;
						
						f = new File(path,newFilename);
						if(!f.exists()) {
							fName = newFilename;
							break;
						}
					}
				}
			}
			try {
				file.transferTo(new File(path,fName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		dog.setUseremail((String)session.getAttribute("logemail"));
		dog.setDog_name(req.getParameter("dog_name"));
		dog.setDog_photo(fName);
		dog.setDog_gender(req.getParameter("dog_gender"));
		dog.setDog_age(dog_age);
		dog.setDog_weight(dog_weight);
		dog.setDog_breed(req.getParameter("dog_breed"));
		dog.setDog_special(req.getParameter("dog_special"));
		try {
			dservice.register(dog);
			List<Dog> dogList = dservice.ownerdog((String)session.getAttribute("logemail"));
			model.addAttribute("dogList", dogList);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center", dir+"center");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
	@RequestMapping("/deletedog")
	public String deletedog(HttpServletRequest req, HttpSession session, Model model) {
		Dog dog = new Dog();
		
		int dog_id = Integer.parseInt(req.getParameter("dog_id"));
		String path = req.getSession().getServletContext().getRealPath("/");
		
		try {
			dog = dservice.get(dog_id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		File f = new File(path,dog.getDog_photo());
		if(f.exists()) f.delete();
		
		try {
			dservice.remove(dog_id);
			List<Dog> dogList = dservice.ownerdog((String)session.getAttribute("logemail"));
			model.addAttribute("dogList", dogList);
			model.addAttribute("left", dir+"left");
			model.addAttribute("center", dir+"center");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage";
	}
}

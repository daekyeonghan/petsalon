package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Dog;
import com.salon.dto.Review;
import com.salon.dto.User;
import com.salon.service.DogService;
import com.salon.service.ResvService;
import com.salon.service.ReviewService;
import com.salon.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DogService dogservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	ResvService rsvservice;
	
	String dir = "user/";
	
	@RequestMapping("/users")
	public String usermain(Model model,  @RequestParam(value = "page", defaultValue = "1") int page) {
		List<User> ulist = null;
		
		
		int paging = 6;
		
		int offset = (page -1) * 6; 
		
	//	System.out.println(page);
		
		try {	
			
		
		ulist = userservice.paginguser(paging, offset);
		
		
		model.addAttribute("page", page);
		model.addAttribute("userlist",ulist);
		model.addAttribute("path","user/member");
		model.addAttribute("content","main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path","fragments");
			model.addAttribute("content","fail");
		}
		return "main";
	}
	
	@RequestMapping("/usersearch")
	public String usersearch(Model model, String searchValue) {
		List<User> ulist = null;
		try {	
		ulist = userservice.usersearch(searchValue);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",ulist);
		model.addAttribute("path",dir+"member");
		model.addAttribute("content","main");
		return "main";
	}
	
	@RequestMapping("/uDelete")
	public String delete(Model model, String delEmail) {
		
	//	System.out.println(delEmail);
		try {
			userservice.remove(delEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/users";
	}
	
	@RequestMapping("/detailPage")
	public String detailPage(Model model,String useremail) {
		User user = null;
		List <Dog> doglist = null;
		List <Review> rlist = null;
		int resvCnt = 0;
		int review = 0;
		
		try {
			user = userservice.get(useremail);
			doglist = dogservice.userDog(useremail);
			rlist = rservice.reviewsearch(useremail);
			resvCnt = rsvservice.userResvCnt(useremail);
			review = rlist.size();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("u",user);
		model.addAttribute("doglist", doglist);
		model.addAttribute("review",review);
		model.addAttribute("resvCnt",resvCnt);
		model.addAttribute("path", dir+"detailPage");
		model.addAttribute("content", "main");
		return "main";
	
		}
	/* 임시 확인용
	@RequestMapping("/userlist")
	public String userlist(Model model) {
		List<User> list = null;
		try {	
		list = userservice.get();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("userlist",list);
		return "userlist_temp";
	}
	*/
}

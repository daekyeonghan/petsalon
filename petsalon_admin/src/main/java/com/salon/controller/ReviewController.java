package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Dog;
import com.salon.dto.Review;
import com.salon.dto.User;
import com.salon.service.DesignerService;
import com.salon.service.DogService;
import com.salon.service.ReviewService;
import com.salon.service.UserService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reservice;
	
	
	String dir = "review/";
	
	@RequestMapping("/review")
	public String main(Model model) {
		List<Review> revlist = null;
		try {
			revlist = reservice.get();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("review",revlist);
		model.addAttribute("path", dir+"review_main");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/review_update")
	public String review_update(Model model, Review review) {
		try {
			reservice.modify(review);
			System.out.println("review");
			
			model.addAttribute("path", dir+"review_ok");
			model.addAttribute("content", "main");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", dir+"review");
			model.addAttribute("content", "fail");
		}
		
		return "main";
	}
	
	
	@RequestMapping("/reviewPage")
	public String reviewPage(Model model,int no) {
		Review rep = null;
		try {
			rep = reservice.get(no);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("rep",rep);
		model.addAttribute("path", dir+"reviewPage");
		model.addAttribute("content", "main");
		return "main";
	}
	

	
	
}

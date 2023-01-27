package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Review;
import com.salon.dto.User;
import com.salon.frame.Util;
import com.salon.service.ResvService;
import com.salon.service.ReviewService;
import com.salon.service.UserService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewservice;
	@Autowired
	ResvService reservice;
	
	String reviewdir = "review/";
	
	@Value("${admindir}")
	String admindir;
	@Value("${userdir}")
	String userdir;
	
	@RequestMapping("")
	public String main(Model model) {
		return "index";
	}
	
	
	@RequestMapping("/review")
	public String reviewselect(Model model, Integer resvcnt, String useremail, HttpSession session) {
		String uemail = (String)session.getAttribute("logemail");
		List<Review> list = null;
		int review_count = 0;
		int resv_count = 0;
		
		try {
			list = reviewservice.reviewselect();
			review_count = reviewservice.review_count(uemail);
			resv_count = reservice.resvcnt(uemail);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("resvcnt", resv_count);
		model.addAttribute("reviewcnt", review_count);
		model.addAttribute("rlist", list);
		model.addAttribute("center", reviewdir+"review_main");
		return "index";
	}
	
	@RequestMapping("/reviewview")
	public String reviewview(Model model, int no) {
		Review rvs = null;
		
		try {
			rvs = reviewservice.get(no);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("rvs", rvs);
		model.addAttribute("center", reviewdir+"review_view");
		return "index";
	}
	
	@RequestMapping("/reviewdelete")
	public String reviewdelete(Model model, Integer review_no, HttpSession session) {
		String uemail = (String)session.getAttribute("logemail");
		
		try {
			int result = reviewservice.reviewDelete(review_no, uemail);
			if(result>0) {
				model.addAttribute("center", reviewdir+"review_main");
			}else {
				model.addAttribute("no", review_no);
				model.addAttribute("center", reviewdir+"review_view");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/reviewupdate")
	public String reviewupdate(Model model, Review review, String originname) {
		
		String blankName = review.getReview_img().getOriginalFilename();
		
		try {
			System.out.println("OK");
			if(review.getReview_img()!= null && blankName.length() != 0) {
				String newName = Util.saveFile(review.getReview_img(), userdir);
				review.setReview_photo(newName);
				reviewservice.modify(review);
				Util.deleteFile(userdir, originname);
			}else {
				reviewservice.nopicUpdate(review);
			}
			model.addAttribute("center", reviewdir+"review_ok");
			
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
			
		}
		
		return "index";
	}
	
	
	@RequestMapping("/reviewsendimpl")
	public String reviewsendimpl(Model model, Review review) {
		String img = review.getReview_img().getOriginalFilename();
		review.setReview_photo(img);
		
		try {
			Util.saveFile(review.getReview_img(),userdir);
			reviewservice.register(review);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", reviewdir+"review_ok");
		return "index";
		/* return "redirect:reviewview?no="+review.getReview_no(); */
	}
	
	

}

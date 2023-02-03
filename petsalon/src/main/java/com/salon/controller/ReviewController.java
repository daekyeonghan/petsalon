package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.dto.Review;
import com.salon.frame.Util;
import com.salon.service.ResvService;
import com.salon.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewservice;
	@Autowired
	ResvService reservice;
	
	String reviewdir = "review/";
	
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
		List<Resv> resvlist = null;
		List<Resv> checkresv = null;
		int review_count = 0;
		int resv_count = 0;
		
		try {
			list = reviewservice.reviewselect();
			review_count = reviewservice.review_count(uemail);
			resv_count = reservice.resvcnt(uemail);
			resvlist = reservice.emailselect(uemail);
			checkresv = reservice.resvcheck(uemail);
			
			model.addAttribute("resvcnt", resv_count);
			model.addAttribute("reviewcnt", review_count);
			model.addAttribute("resvlist", resvlist);
			model.addAttribute("rlist", list);
			model.addAttribute("center", reviewdir+"review_main");
			model.addAttribute("checkresv", checkresv);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/reviewview")
	public String reviewview(Model model, int no) {
		Review rvs = null;
		
		try {
			rvs = reviewservice.get(no);
			model.addAttribute("rvs", rvs);
			model.addAttribute("center", reviewdir+"review_view");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/reviewdelete")
	public String reviewdelete(Model model, Integer review_no, String filename) {
		
		try {
			reviewservice.reviewDelete(review_no);
			if(!filename.equals("haro.png")) {
				Util.deleteFile(userdir, filename);
			}
			return "redirect:/review";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/reviewupdate")
	public String reviewupdate(Model model, Review review, String originname) {
		
		
		String blankName = review.getReview_img().getOriginalFilename();
		
		try {
			if(review.getReview_img()!= null && blankName.length() != 0) {
				String newName = Util.saveFile(review.getReview_img(), userdir);
				review.setReview_photo(newName);
				reviewservice.modify(review);
				Util.deleteFile(userdir, originname);
			}else {
				reviewservice.nopicUpdate(review);
			}
			
			
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
			
		}
		
		model.addAttribute("center", reviewdir+"review_updateok");
		return "index";
	}
	
	
	@RequestMapping("/reviewsendimpl")
	public String reviewsendimpl(Model model, Review review) {
		String img = review.getReview_img().getOriginalFilename();
		
		try {
			if(review.getReview_img()!=null && img.length()!=0) {
				String newName = Util.saveFile(review.getReview_img(),userdir);
				review.setReview_photo(newName);
			}
			else {
				reviewservice.nopicUpdate(review);
				review.setReview_photo("haro.png");
			}
			reviewservice.register(review);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", reviewdir+"review_ok");
		return "index";
		/* return "redirect:reviewview?no="+review.getReview_no(); */
	}
	
	@RequestMapping("/review_write")
	public String reviewwrite(Model model, HttpSession session, int no) {
		Resv resv;
		
		try {
			resv = reservice.get(no);
			model.addAttribute("rwresv", resv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("center", reviewdir+"review_write");
		return "index";
	}
	
	

}

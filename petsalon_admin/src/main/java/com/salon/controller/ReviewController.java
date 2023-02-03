package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Dog;
import com.salon.dto.Review;
import com.salon.dto.Review_Answer;
import com.salon.dto.Shop_Notice;
import com.salon.dto.User;
import com.salon.service.DesignerService;
import com.salon.service.DogService;
import com.salon.service.ReviewService;
import com.salon.service.Review_AnswerService;
import com.salon.service.UserService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reservice;
	
	@Autowired
	Review_AnswerService answerService;
	
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
	
	@RequestMapping("/reviewPage")
	public String reviewPage(Model model,Integer no) {
		Review rep = null;
		List<Review_Answer> adr = null;
		try {
			rep = reservice.get(no);
			adr = answerService.adminreview(no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("rep",rep);
		model.addAttribute("adr",adr);
		model.addAttribute("path", dir+"reviewPage");
		model.addAttribute("content", "main");
		return "main";
	}
	
	
	
	
	
	
	@RequestMapping("/reviewregister")
	public String reviewregister(Model model,Review_Answer review_answer) {
		Review_Answer rag= null;
		try {
			
			answerService.register(review_answer);			
			System.out.println("ok");
			/*
			 * model.addAttribute("path", dir+"reviewPage"); model.addAttribute("content",
			 * "main");
			 */
		}catch(Exception e) {
			e.printStackTrace();
			
		System.out.println("fail");
		model.addAttribute("path",	"fragments");
		model.addAttribute("content", "fail");
		}
		return "redirect:/review";
	}
	
	
	
	@RequestMapping("/adminUpdatePage")
	public String adupp(Model model, Integer updno ) {
		System.out.println(updno);
		Review_Answer ra = new Review_Answer();
		try {
			ra = answerService.get(updno);
			System.out.println(updno);	//리뷰답변번호 출
			model.addAttribute("ra", ra);
			model.addAttribute("path", dir + "reviewAns_update");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}
	
	
	@RequestMapping("/reviewAns_Update")
	public String reviewAnsUpdate(Model model, Review_Answer ad ) {
		
		System.out.println(ad);
		
		try {
			
			
			answerService.modify(ad);
			
			System.out.println("update ok");
			
			return "redirect:/review";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
		
	}
	
	
	
	
	@RequestMapping("/rDelete")
	public String delete(Model model, Integer delno) {
		
		
		try {
			answerService.remove(delno);
			System.out.println("okok");
			return "redirect:/review";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
		
	}
	
}
	


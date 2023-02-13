package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Designer;
import com.salon.dto.Dog;
import com.salon.dto.Item;
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
	public String main(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Review> revlist = null;

		int recordsPerPage = 6;

		int offset= (page - 1) * 6; //한페이지의 시작번호

	//	System.out.println(page);
		try {

			revlist = reservice.pagingreview(recordsPerPage, offset);
			

			model.addAttribute("review", revlist);
			model.addAttribute("page", page);
			model.addAttribute("path", "review/review_main");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}
	
	@RequestMapping("/reviewsearch")
	public String reviewsearch(Model model, String searchValue, String useremail) {
		List<Review> revlist = null;
		try {	
		revlist = reservice.reviewsearch(searchValue);
		
		System.out.println(useremail);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("review",revlist);
		model.addAttribute("path",dir+"review_main");
		model.addAttribute("content","main");
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

		
		if(adr.size()==0) {
			model.addAttribute("noAnswer",1);
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
	
	
	/*@RequestMapping("/reviewSort")
	public String sortreview(Model model,String designer_id ,@RequestParam(value = "page", defaultValue = "1") int page) {
		List<Review> revlist = null;
		
		

		int paging = 6;

		int offset = (page - 1) * 6;

		try {
			System.out.println(designer_id);

			revlist = reservice.sortreview(designer_id,paging, offset);	
					
			
			model.addAttribute("menulist", revlist);
			
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}*/
	
	
	
	
	
	@RequestMapping("/reviewAns_Update")
	public String reviewAnsUpdate(Model model, Review_Answer ad ) {
		
	//	System.out.println(ad);
		
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
	//		System.out.println("okok");
			return "redirect:/review";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
		
	}
	
}
	


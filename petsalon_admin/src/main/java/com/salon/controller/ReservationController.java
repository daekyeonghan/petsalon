package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Dog;
import com.salon.dto.Resv;
import com.salon.dto.User;
import com.salon.service.DogService;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;
import com.salon.service.UserService;

@Controller
public class ReservationController {

	String dir = "reservation/";
	
	@Autowired
	ResvService rservice;
	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	DogService dservice;
	
	@Autowired
	UserService uservice;
	
	@RequestMapping("/reservation")
	public String main(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		
		List<Resv> rlist = null;
		
		int recordsPerPage = 10;

		int offset = (page - 1) * 10;

		try {
			int rcheck = rservice.notFixed().size();
			rlist = rservice.resvList(recordsPerPage, offset);
			model.addAttribute("rlist",rlist);
			model.addAttribute("rcheck",rcheck);
			
			model.addAttribute("path", dir+"reservation_main");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
		
		return "main";
	}
	
	
	@RequestMapping("/resvInfo")
	public String resvFix(Model model, Integer no) {
		
		Resv resv = null;
		Resv resvTwo = null;
		Dog dog = null;
		User user = null;
		
		try {
			
			resv = rservice.selectList(no);
			resvTwo = rservice.get(no);
			dog = dservice.get(resvTwo.getDog_id());
			user = uservice.get(resvTwo.getUseremail());
			
			model.addAttribute("r",resv);
			model.addAttribute("rtwo",resvTwo);
			model.addAttribute("d",dog);
			model.addAttribute("u",user);
			
			model.addAttribute("path", dir+"reservation_detail");
			model.addAttribute("content", "main");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
		
	}
	
	@RequestMapping("/resvFix")
	public String resvFix(int no) {
		
		try {
			rservice.resvFixUpdate(no,1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/resvInfo?no="+no;
		
	}
	
	@RequestMapping("/resvCancel")
	public String resvCancel(Model model, Integer no) {
		
		Resv resv = null;
		Resv resvTwo = null;
		Dog dog = null;
		User user = null;
		

		try {
			resv = rservice.selectList(no);
			resvTwo = rservice.get(no);
			user = uservice.get(resvTwo.getUseremail());
			dog = dservice.get(resvTwo.getDog_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("r",resv);
		model.addAttribute("rtwo",resvTwo);
		model.addAttribute("d",dog);
		model.addAttribute("u",user);
		
		
		model.addAttribute("path",dir+"reservation_cancel");
		model.addAttribute("content","main");
		
		return "main";
	}
	
	@RequestMapping("/resvCancelFix")
	public String resvCancelFix(Model model, int resv_no, String cancel) {
		
		
		try {
			rservice.resvCancel(resv_no, cancel);
			
			schservice.scheduleDel(resv_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/reservation";
	}
	
	
	
	
}

package com.salon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Resv;
import com.salon.dto.Schedule;
import com.salon.service.DesignerService;
import com.salon.service.DogService;
import com.salon.service.ItemService;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;

@Controller
public class ResvController {
	@Autowired
	DogService dogservice;
	@Autowired
	DesignerService deservice;
	@Autowired
	ItemService iservice;
	@Autowired
	ScheduleService scservice;
	@Autowired
	ResvService rservice;
	
	String dir = "myresv/";
	
	@RequestMapping("/resv")
	public String resv(Model model, HttpSession session) {
		String useremail = (String)session.getAttribute("logemail");
		try {
			model.addAttribute("dog", dogservice.ownerdog(useremail));
			model.addAttribute("designer",deservice.designerItem());
			model.addAttribute("item", iservice.get());
			model.addAttribute("schedule", scservice.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "resv";
	}
	
	@RequestMapping("/resvOk")
	public String resv(HttpServletRequest req, HttpSession session) {
		Resv resv = new Resv();
		
		resv.setUseremail((String)session.getAttribute("logemail"));
		resv.setDog_id(Integer.parseInt(req.getParameter("dog_id")));
		resv.setDesigner_id(req.getParameter("designer_id"));
		resv.setItem_id(Integer.parseInt(req.getParameter("item_id")));
		resv.setResv_ask(req.getParameter("resv_ask"));
		resv.setResv_fix(Integer.parseInt(req.getParameter("resv_fix")));
		resv.setCancel(req.getParameter("cancel"));
		
		Schedule sc = new Schedule();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {
			rservice.register(resv);
			date = sdf.parse(req.getParameter("sc_date"));
			sc.setDesigner_id(req.getParameter("designer_id"));
			sc.setResv_no(rservice.resvnoSelect());
			sc.setSc_date(date);
			scservice.register(sc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Register Error");
		}
		return "index";
	}
}

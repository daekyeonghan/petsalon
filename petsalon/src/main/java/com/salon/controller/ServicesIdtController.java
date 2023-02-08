package com.salon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.service.DesignerService;
import com.salon.service.DogService;
import com.salon.service.ItemService;
import com.salon.service.ScheduleService;

@Controller
public class ServicesIdtController {
	
	@Autowired
	DesignerService deservice;
	@Autowired
	ItemService iservice;
	
	
	@RequestMapping("/servicesintroduction")
	public String main(Model model, HttpSession session) {
		String useremail = (String)session.getAttribute("logemail");
		try {
			model.addAttribute("designer",deservice.get());
			model.addAttribute("item", iservice.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "servicesintroduction";
	}
	
	@RequestMapping("/Designerlist")
	public String introD(Model model) {
		List<Designer> d = null;
		List<Item> i = null;
		try {
			d = deservice.get();
			i = iservice.get();
			model.addAttribute("designer", d);
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "servicesintroduction/servicesintrodes";
	}
	
	@RequestMapping("/servicesintrodm")
	public String introM(Model model) {
		model.addAttribute("");
		return "servicesintroduction/servicesintrodm";
	}
}

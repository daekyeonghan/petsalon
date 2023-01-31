package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.dto.Schedule;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;
import com.salon.service.ScheduleService;

@Controller
public class ScheduleController {

	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	DesignerService dsservice;
	
	@Autowired
	ItemService iservice;
	
	String dir = "schedule/";
	
	@Value("${admindir}")
	String admindir;
	
	
	@RequestMapping("/schedule")
	public String getlistds(Model model, String designer_id) {

		Designer ds = null;
		List<Item> ilist = null;
		List<Schedule> schlist = null;
				
		try {
			
			ds = dsservice.get(designer_id);
			ilist = iservice.dsMenu(designer_id);
			schlist =  schservice.dsSchedule(designer_id);
			
			model.addAttribute("path", dir+"schedule_main");
			model.addAttribute("content", "main");
			model.addAttribute("ilist",ilist);
			model.addAttribute("ds",ds);
			model.addAttribute("schlist",schlist);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
	
		return "main";
	}
}

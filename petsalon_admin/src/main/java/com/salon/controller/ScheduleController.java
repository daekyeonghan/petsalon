package com.salon.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.dto.Resv;
import com.salon.dto.Schedule;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;

@Controller
public class ScheduleController {

	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	DesignerService dsservice;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	ResvService resvservice;
	
	String dir = "schedule/";

	
	@RequestMapping("/schedule")
	public String getlistds(Model model, String designer_id) {

		JSONArray dsscharr = new JSONArray();
		
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Designer ds = null;
		
		List<Resv> resvlist = null;
		
		List<Item> ilist = null;
		
		List<Schedule> schlist = null;
		
		int schcnt = 0;
				
		try {
			
			resvlist = resvservice.dsScheduleList("sejong");

			for(Resv resv : resvlist) {
				JSONObject obj = new JSONObject();
				obj.put("title", " [ 예약자 : "+resv.getUsername()+"("+resv.getDog_name()+") ] ");
				obj.put("start", newDtFormat.format(resv.getSc_date()));
				dsscharr.add(obj);
			}
			
			ds = dsservice.get(designer_id);
			ilist = iservice.dsMenu(designer_id);
			schlist =  schservice.dsSchedule(designer_id);
			schcnt = schlist.size();
			
			model.addAttribute("path", dir+"schedule_main");
			model.addAttribute("content", "main");
			model.addAttribute("ilist",ilist);
			model.addAttribute("dsscharr",dsscharr);
			model.addAttribute("ds",ds);
			model.addAttribute("schlist",schlist);
			model.addAttribute("schcnt",schcnt);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
	
		return "main";
	}
}

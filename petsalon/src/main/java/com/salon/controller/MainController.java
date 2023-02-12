package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Item;
import com.salon.dto.Shop_Notice;
import com.salon.service.ItemService;
import com.salon.service.Shop_NoticeService;

@Controller
public class MainController {
	
	String dir = "notice/";
	
	@Autowired
	Shop_NoticeService snservice;
	@Autowired
	ItemService iservice;
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("center", "demoindex");
		try {
			List<Item> list = iservice.get();
			model.addAttribute("item", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/notice")
	public String notice(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {
		List<Shop_Notice> snlist = null;

		int recordsPerPage = 7;

		int offset = (page - 1) * 7;
		
		try {
			
			snlist = snservice.noticePaging(recordsPerPage, offset);
			
			model.addAttribute("snlist",snlist);
			model.addAttribute("center", dir+"notice");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/noticecontent")
	public String noticecontent(Model model, int no) {
		Shop_Notice sn = null;
		
		try {
			sn = snservice.get(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("sn",sn);
		model.addAttribute("center",dir+"notice_content");
		return "main";
	}

}

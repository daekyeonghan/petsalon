package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iservice;
	
	@Autowired
	DesignerService dsservice;
	
	String dir = "item/";
	
	@RequestMapping("/item")
	public String main(Model model) {
		List<Item> ilist = null;
		List<Designer> dlist = null;
		try {
			ilist = iservice.getlist();
			dlist = dsservice.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("menulist",ilist);
		model.addAttribute("designerlist",dlist);
		model.addAttribute("path", dir+"item_main");
		model.addAttribute("content", "main");
		return "main";
	}
	

	@RequestMapping("/itemRegister")
	public String register(Model model, Item item) {
		
		
		try {
			iservice.register(item);
			System.out.println("item register ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	
		model.addAttribute("path", dir+"item_ok");
		model.addAttribute("content", "main");
		
		return "main";
	}
	
	@RequestMapping("/itemtemp")
	public String itemtemp(Model model) {
		List<Item> ilist = null;
		List<Designer> dlist = null;
		try {
			ilist = iservice.getlist();
			dlist = dsservice.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("menulist",ilist);
		model.addAttribute("designerlist",dlist);
		model.addAttribute("path", dir+"item_temp");
		model.addAttribute("content", "main");
		return "main";
		
		
	}
	
}

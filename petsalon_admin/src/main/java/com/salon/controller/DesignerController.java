package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salon.dto.Designer;
import com.salon.service.DesignerService;

@Controller
public class DesignerController {

	@Autowired
	DesignerService dsservice;
	
	String dir = "designer/";
	
	@RequestMapping("/designer")
		public String getlistds(Model model) {
			List<Designer> list = null;
			try {
				list = dsservice.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("path", dir+"designer_main");
			model.addAttribute("content", "main");
			model.addAttribute("list",list);
			return "main";
		}
	
	
	@RequestMapping("/designeradd")
	public String designeradd(Model model) {
		model.addAttribute("path", dir+"designer_add");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/designerRegister")
	public String register(Model model, Designer designer) {
		
		
		try {
			dsservice.register(designer);
			System.out.println("designer register ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	
		model.addAttribute("path", dir+"designer_ok");
		model.addAttribute("content", "main");
		
		return "main";
	}
	
	@RequestMapping("/designerDelete")
	public String deldesigner(Model model, String id) {
		
		try {
			dsservice.remove(id);
			System.out.println("designer deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("path", dir+"designer_ok");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/designerUpdatePage")
	public String uppage(Model model, String id) {
		Designer ds = new Designer();
		
		try {
			ds = dsservice.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ds",ds);
		model.addAttribute("path", dir+"designer_update");
		model.addAttribute("content", "main");
		return "main";
	}
	
	@RequestMapping("/designerUpdate")
	public String updateDesigner(Model model, Designer designer) {
		try {
			dsservice.modify(designer);
			System.out.println("designer updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("path", dir+"designer_ok");
		model.addAttribute("content", "main");
		return "main";
	}
}


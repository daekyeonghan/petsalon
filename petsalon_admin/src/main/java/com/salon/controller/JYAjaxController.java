package com.salon.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Admin;
import com.salon.dto.Designer;
import com.salon.service.AdminService;
import com.salon.service.DesignerService;

@RestController
public class JYAjaxController {

	@Autowired
	DesignerService dsservice;

	@RequestMapping("/designerRegi")
	public String register(Model model, Designer designer) {
		try {
			dsservice.register(designer);
			System.out.println("ok");
			// model.addAttribute("obj",designer);
			// model.addAttribute("center",dir+"registerok");
		} catch (Exception e) {
			// model.addAttribute("center",dir+"registerfail");
			e.printStackTrace();
			System.out.println("fail");
		}
		// model.addAttribute("left",dir+"left");

		model.addAttribute("path", "designer/designer_main");
		model.addAttribute("content", "main");
		return "main";
	}
	/*
	 * @RequestMapping("/designerlist") public Object getlist(Model model, Designer
	 * designer) {
	 * 
	 * List<Designer> list = new ArrayList<Designer>(); JSONArray ar = new
	 * JSONArray(); try { list = dsservice.get(); for(Designer ds:list) { JSONObject
	 * obj = new JSONObject(); obj.put("designer_id", ds.getDesigner_id());
	 * obj.put("designer_name", ds.getDesigner_name()); obj.put("designer_photo",
	 * "jyassets/img/"+ds.getDesigner_photo()); obj.put("designer_introduce",
	 * ds.getDesigner_introduce()); ar.add(obj); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * //model.addAttribute(list); return ar; }
	 */

	@RequestMapping("/checkid")
	public Object checkid(String dsid) {
		int result = 0;
		Designer ds = new Designer();
		try {
			ds = dsservice.get(dsid);
			if (ds != null) {
//			System.out.println(ds);
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}

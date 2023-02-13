package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Designer;
import com.salon.frame.ImgUtil;
import com.salon.service.DesignerService;

@Controller
public class DesignerController {

	@Autowired
	DesignerService dsservice;
	
	String dir = "designer/";
	
	@Value("${admindir}")
	String admindir;
	

	@Value("${userdir}")
	String userdir;
	
	
	@RequestMapping("/designer")
		public String getlistds(Model model) {
			List<Designer> list = null;
			try {
				list = dsservice.get();
				model.addAttribute("path", dir+"designer_main");
				model.addAttribute("content", "main");
				model.addAttribute("list",list);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("path", "fragments");
				model.addAttribute("content", "fail");
			}
		
			return "main";
		}

	
	@RequestMapping("/designerRegister")
	public String register(Model model, Designer designer) {

		// LocalDateTime now = LocalDateTime.now();
		//	String newFileName = designer_photo + "_" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		String blankName = designer.getDesigner_img().getOriginalFilename();
		
		try {
			if(designer.getDesigner_img()!=null&&blankName.length()!=0){
				String newName = ImgUtil.saveFile(designer.getDesigner_img(), admindir, userdir);
				designer.setDesigner_photo(newName);
				
			}
			else {
				designer.setDesigner_photo("haro.png");
			}
			dsservice.register(designer);
			return "redirect:/designer";
//			System.out.println("designer register ok");
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			System.out.println("designer register fail");
			
		}
		
		return "main";
	}
	
	@RequestMapping("/designerDelete")
	public String deldesigner(Model model, String id, String filename) {
		
		try {
			dsservice.remove(id);
			if(!filename.equals("haro.png")) {
				ImgUtil.deleteFile(admindir, userdir, filename);
			}
			System.out.println("designer deleted");
			return "redirect:/designer";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
	
	}
	
	@RequestMapping("/designerUpdatePage")
	public String uppage(Model model, String id) {
		Designer ds = new Designer();
		
		try {
			ds = dsservice.get(id);
			model.addAttribute("ds",ds);
			model.addAttribute("path", dir+"designer_update");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}
	
	
	
	@RequestMapping("/designerUpdate")
	public String updateDesigner(Model model, Designer designer,String originname) {

		System.out.println(originname);
		
		String blankName= designer.getDesigner_img().getOriginalFilename();

		try {
			if(designer.getDesigner_img()!=null&&blankName.length()!=0){
				String newName = ImgUtil.saveFile(designer.getDesigner_img(), admindir, userdir);
				designer.setDesigner_photo(newName);
				dsservice.modify(designer);
					if(!originname.equals("haro.png")) {
						ImgUtil.deleteFile(admindir, userdir, originname);
					}
				}
				else {
					dsservice.nopicUpdate(designer);
				}
			
			System.out.println("designer updated");
			model.addAttribute("path", dir+"designer_ok");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
	
		return "main";
	}
	

}


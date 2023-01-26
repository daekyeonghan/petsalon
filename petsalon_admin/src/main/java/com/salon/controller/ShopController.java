package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salon.dto.Shop_Notice;
import com.salon.frame.ImgUtil;
import com.salon.service.Shop_NoticeService;

@Controller
public class ShopController {

	String dir = "shop/";
	
	@Autowired
	Shop_NoticeService snservice;
	
	@Value("${admindir}")
	String admindir;
	
	@RequestMapping("/shop")
	public String main(Model model) {
		List<Shop_Notice> snlist = null;
		try {
			snlist = snservice.get();
			
			model.addAttribute("snlist",snlist);
			model.addAttribute("path", dir+"shop_main");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
		
	
		return "main";
	}
	
	@RequestMapping("/shopNotice")
	public String notice(Model model, int no) {
		Shop_Notice sn = null;
		
		try {
			sn = snservice.get(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("sn",sn);
		model.addAttribute("path",dir+"shop_notice_content");
		model.addAttribute("content","main");
		return "main";
	}
	
	
	@RequestMapping("/noticeAdd")
	public String noticeAdd(Model model) {
		
		model.addAttribute("path",dir+"shop_notice_register");
		model.addAttribute("content","main");
		return "main";
	}
	
	@RequestMapping("/noticeRegister")
	public String noticeRegister(Model model, Shop_Notice notice) {
		// LocalDateTime now = LocalDateTime.now();
		//	String newFileName = designer_photo + "_" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		String blankName = notice.getSn_img().getOriginalFilename();
		
		try {
			if(notice.getSn_img()!=null&&blankName.length()!=0){
				String newName = ImgUtil.saveFile(notice.getSn_img(), admindir);
				notice.setSn_photo(newName);
			}
			
			snservice.register(notice);
			System.out.println("shop notice register ok");
			model.addAttribute("path", dir+"shop_ok");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}
		
		return "redirect:/shop";
	}
}

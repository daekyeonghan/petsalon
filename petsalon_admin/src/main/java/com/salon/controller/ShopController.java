package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Item;
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
	public String main(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {
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
			return "redirect:/shop";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
		
		
	}

	

		
	@RequestMapping("/noticeUpdatePage")
	public String uppage(Model model, int sn_no) {
		Shop_Notice sn = new Shop_Notice();
		try {
			sn = snservice.get(sn_no);
			System.out.println(sn_no);
			model.addAttribute("sn", sn);
			model.addAttribute("path", dir + "shop_notice_update");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}
	
	@RequestMapping("/noticeUpdate")
	public String noticeUpdate(Model model, Shop_Notice sn, String originname) {

		System.out.println(originname);

		String blankName = sn.getSn_img().getOriginalFilename();

		try {
			if (sn.getSn_img() != null && blankName.length() != 0) {
				String newName = ImgUtil.saveFile(sn.getSn_img(), admindir);
				sn.setSn_photo(newName);
				ImgUtil.deleteFile(admindir, originname);
			} else {
				sn.setSn_photo(originname);
			}

			snservice.modify(sn);

			System.out.println("item updated");
			
			return "redirect:/item";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}

		
	}
	

	@RequestMapping("/noticeDelete")
	public String del(Model model, Integer no, String filename) {

		try {
			snservice.remove(no);
			ImgUtil.deleteFile(admindir, filename);
			System.out.println("shop_notice deleted");
			return "redirect:/shop";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}

		
	}
}

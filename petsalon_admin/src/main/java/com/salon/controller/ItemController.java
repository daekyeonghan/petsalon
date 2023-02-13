package com.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon.dto.Designer;
import com.salon.dto.Item;
import com.salon.frame.ImgUtil;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iservice;

	@Autowired
	DesignerService dsservice;

	String dir = "item/";

	@Value("${admindir}")
	String admindir;

	@Value("${userdir}")
	String userdir;

	@RequestMapping("/item")
	public String main(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Item> ilist = null;

		List<Designer> dlist = null;

		int recordsPerPage = 6;

		int offset = (page - 1) * 6;

	//	System.out.println(page);
		try {

			ilist = iservice.pagingitem(recordsPerPage, offset);
			dlist = dsservice.get();

			model.addAttribute("menulist", ilist);
			model.addAttribute("dslist", dlist);
			model.addAttribute("path", "item/item_main");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}

	@RequestMapping("/itemSortByDesigner")
	public String sortitem(Model model, String designer_id, int page) {
		List<Item> ilist = null;
		List<Designer> dlist = null;
		Designer ds = new Designer();

		int recordsPerPage = 6;

		int offset = (page - 1) * 6;

		try {
	//		System.out.println(designer_id);

			ilist = iservice.sortitem(designer_id, recordsPerPage, offset);
			dlist = dsservice.get();
			ds = dsservice.get(designer_id);

			String dsname = ds.getDesigner_name();

			// System.out.println(ilist);
			model.addAttribute("menulist", ilist);
			model.addAttribute("designerlist", dlist);
			model.addAttribute("dsname", dsname);
			model.addAttribute("path", dir + "item_sort");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}

	@RequestMapping("/itemRegister")
	public String register(Model model, Item item) {

		String blankName = item.getItem_img().getOriginalFilename();

		try {
			if (item.getItem_img() != null && blankName.length() != 0) {
				String newName = ImgUtil.saveFile(item.getItem_img(), admindir, userdir);
				item.setItem_photo(newName);

			}
			iservice.register(item);
			System.out.println("item register ok");
			return "redirect:/item?page=1";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}

		
	}

	@RequestMapping("/itemDelete")
	public String deldesigner(Model model, Integer id,String filename) {

		try {
			iservice.remove(id);
			ImgUtil.deleteFile(admindir, userdir, filename);
			System.out.println("item deleted");
			return "redirect:/item";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}
		
	}

	@RequestMapping("/itemUpdatePage")
	public String uppage(Model model, Integer id) {
		Item it = new Item();
		try {
			it = iservice.get(id);
	//		System.out.println(id);
			model.addAttribute("it", it);
			model.addAttribute("path", dir + "item_update");
			model.addAttribute("content", "main");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
		}

		return "main";
	}

	@RequestMapping("/itemUpdate")
	public String updateItem(Model model, Item item, String originname) {

		System.out.println(originname);

		String blankName = item.getItem_img().getOriginalFilename();

		try {
			if (item.getItem_img() != null && blankName.length() != 0) {
				String newName = ImgUtil.saveFile(item.getItem_img(), admindir, userdir);
				item.setItem_photo(newName);
				ImgUtil.deleteFile(admindir, userdir, originname);
			} else {
				item.setItem_photo(originname);
			}

			iservice.modify(item);

			System.out.println("item updated");
			
			return "redirect:/item?page=1";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("path", "fragments");
			model.addAttribute("content", "fail");
			return "main";
		}

		
	}



}

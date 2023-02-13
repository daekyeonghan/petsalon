package com.salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.service.AdminService;
import com.salon.service.DesignerService;
import com.salon.service.ItemService;
import com.salon.service.ResvService;
import com.salon.service.ReviewService;
import com.salon.service.ScheduleService;
import com.salon.service.Shop_NoticeService;
import com.salon.service.UserService;

@RestController
public class PageAjaxController {

	
	@Autowired
	AdminService adservice;
	
	@Autowired
	ReviewService reservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DesignerService dsservice;
	
	@Autowired
	ItemService iservice;
	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	ResvService resvservice;
	
	@Autowired
	Shop_NoticeService snservice;
	
	
	
	 @RequestMapping("/itemTotalPage")
	    public Object itemTotalPage() {
	        int recordsPerPage = 6;
	        int totalPages = 0;

	    	try {
				int totalRecords = iservice.totalitem();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	
	 @RequestMapping("/dsitemTotalPage")
	    public Object dsitemTotalPage(String designer_id) {
	        int recordsPerPage = 6;
	        int totalPages = 0;

	    	try {
				int totalRecords = iservice.totaldsitem(designer_id);
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
		  //    System.out.println(totalPages);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	 @RequestMapping("/resvTotalPage")
	    public Object resvTotalPage() {
	        int recordsPerPage = 15;
	        int totalPages = 0;

	    	try {
				int totalRecords = resvservice.get().size();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	 @RequestMapping("/noticeTotalPage")
	    public Object noticeTotalPage() {
	        int recordsPerPage = 7;
	        int totalPages = 0;

	    	try {
				int totalRecords = snservice.get().size();
		        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed to get total pages");
			}
	    	
	    //	System.out.println(totalPages);

	        return totalPages;
	    }
	 
	
	@RequestMapping("/reviewTotalPage")
    public Object reviewTotalPage() {
        int paging = 6;
        int totalPage = 0;

    	try {
			int totalRecords = reservice.totalreview();
	        totalPage = (int) Math.ceil(totalRecords * 1.0 / paging);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to get total pages");
		}
    	
    //	System.out.println(totalPages);

        return totalPage;
    }
	
	@RequestMapping("/userTotalPage")
    public Object userTotalPage() {
        int paging = 6;
        int totalPage = 0;

    	try {
			int totalRecords = userservice.totaluser();
	        totalPage = (int) Math.ceil(totalRecords * 1.0 / paging);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to get total pages");
		}
    	
    //	System.out.println(totalPages);

        return totalPage;
    }
	
}

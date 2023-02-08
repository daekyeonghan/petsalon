package com.salon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Admin;
import com.salon.service.AdminService;
import com.salon.service.ReviewService;
import com.salon.service.UserService;

@RestController
public class WKAjaxController {

	@Autowired
	AdminService adservice;
	
	@Autowired
	ReviewService reservice;
	
	@Autowired
	UserService userservice;
	
//	@RequestMapping("/loginimpl")
//	public Object loginimpl(String admin_id, String admin_pwd, HttpSession session) {
//		int result = 0;
//
//		Admin admin = null;
//		try {
//			admin = adservice.get(admin_id);
//			if (admin == null) {
//				result = 0;
//			} else {
//				if (admin.getAdmin_pwd().equals(admin_pwd)) {
//					System.out.println(admin_id);
//					result = 1;
//					session.setAttribute("logemail",admin_id);
//					session.setAttribute("logpwd", admin_pwd);
//				} else
//					result = 0;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
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

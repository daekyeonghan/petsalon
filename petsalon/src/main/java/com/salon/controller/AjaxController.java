package com.salon.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Schedule;
import com.salon.dto.User;
import com.salon.service.ScheduleService;
import com.salon.service.UserService;

@RestController
public class AjaxController {
	@Autowired
	UserService uservice;
	@Autowired
	ScheduleService scservice;
	
	@RequestMapping("/findemail")
	public Object findemail(String username, String tel) {
		String useremail = null;
		try {
			useremail = uservice.findemail(username, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return useremail;
	}
	@RequestMapping("/findpwd")
	public Object findpwd(String useremail) {
		String pwd = null;
		try {
			pwd = uservice.findpwd(useremail);
			System.out.println(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
	@RequestMapping("/weekSchedule")
	public Object weekSchedule() {
		List<Schedule> resvlist = null;
		JSONArray scharr = new JSONArray();
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			
		try {
			resvlist = scservice.get();
			for(Schedule resv : resvlist) {
				JSONObject obj = new JSONObject();
				obj.put("title", "예약 불가");
				obj.put("start", newDtFormat.format(resv.getSc_date()));
				scharr.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail to load schedule");
		}
		return scharr;
	}
	@RequestMapping("/scheduleCheck")
	public Object scheduleCheck(String info) {
		List<Schedule> list = null;
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, +2);
        String compare = newDtFormat.format(cal.getTime());
        
        int result = 0;
        
        int operation = compare.compareTo(info);
        if(operation>0) {
        	return 0;
        }
		
		try {
			list = scservice.get();
			for(int i=0;i<list.size();i++) {
				if(newDtFormat.format(list.get(i).getSc_date()).equals(info)) {
					result = 0;
					break;
				}else {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

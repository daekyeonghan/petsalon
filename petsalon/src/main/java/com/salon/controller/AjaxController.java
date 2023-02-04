package com.salon.controller;

import java.text.SimpleDateFormat;
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
}

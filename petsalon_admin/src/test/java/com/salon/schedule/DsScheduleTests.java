package com.salon.schedule;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;



@SpringBootTest
class DsScheduleTests {
	
	@Autowired
	ScheduleService schservice;
	
	@Autowired
	ResvService resvservice;

	@Test
	void contextLoads() {
		
		List<Resv> resvlist = null;
		
		JSONArray dsscharr = new JSONArray();
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			resvlist = resvservice.dsScheduleList("sejong");

			for(Resv resv : resvlist) {
				JSONObject obj = new JSONObject();
				obj.put("title", " [ 예약자 : "+resv.getUsername()+"("+resv.getDog_name()+") ] ");
				obj.put("start", newDtFormat.format(resv.getSc_date()));
				dsscharr.add(obj);
			}
			System.out.println(dsscharr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail to load schedule");
		}
	
	}
}


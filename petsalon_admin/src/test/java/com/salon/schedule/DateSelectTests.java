package com.salon.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.dto.Schedule;
import com.salon.frame.MailUtil;
import com.salon.service.ResvService;
import com.salon.service.ScheduleService;



@SpringBootTest
class DateSelectTests {
	
	@Autowired
	ScheduleService service;
	
	@Autowired
	ResvService rservice;

	@Test
	void contextLoads() {
		String useremail = "hdk1008@gmail.com";
		Schedule shd = null;
		Date date = null;
		Resv resv = null;
		String dog_name;
		String designer_name;
		String item_name;
		DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 h시");
		try {
			shd = service.dateselect(1032);
			date = shd.getSc_date();
			resv = rservice.mailinformation(1034);
			String dateToStr = dateFormat.format(date);
			System.out.println(shd);
			System.out.println(date);
			System.out.println(dateToStr);
			System.out.println("메일정보" + resv);
			dog_name = resv.getDog_name();
			designer_name = resv.getDesigner_name();
			item_name = resv.getItem_name();
			System.out.println("강아지정보" + dog_name);
			System.out.println("디자이너정보" + designer_name);
			System.out.println("컷정보" + item_name);
			MailUtil.confirmEmail(dateToStr, useremail, dog_name, designer_name, item_name);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

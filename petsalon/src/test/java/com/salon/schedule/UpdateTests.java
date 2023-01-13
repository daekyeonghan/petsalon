package com.salon.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Schedule;
import com.salon.service.ScheduleService;



@SpringBootTest
class UpdateTests {
	
	@Autowired
	ScheduleService service;

	@Test
	void contextLoads() {
		Schedule shd = new Schedule(3,"seomin97",1000,null);
		try {
			service.modify(shd);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

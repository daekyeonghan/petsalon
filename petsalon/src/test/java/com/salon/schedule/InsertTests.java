package com.salon.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Schedule;
import com.salon.service.ScheduleService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	ScheduleService service;

	@Test
	void contextLoads() {
		 Schedule scd= new Schedule(3,"seomin97",1000,null);
		try {
			service.register(scd);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			//e.printStackTrace();
		}
	}

}

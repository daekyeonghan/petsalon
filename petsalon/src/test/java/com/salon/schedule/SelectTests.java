package com.salon.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Schedule;
import com.salon.service.ScheduleService;



@SpringBootTest
class SelectTests {
	
	@Autowired
	ScheduleService service;

	@Test
	void contextLoads() {
		Schedule shd = null;
		try {
			shd = service.get(3);
			System.out.println(shd);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

package com.salon.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ResvService;
import com.salon.service.ScheduleService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	ScheduleService service;

	@Test
	void contextLoads() {
		try {
			service.remove(3);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}
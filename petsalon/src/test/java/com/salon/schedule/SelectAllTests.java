package com.salon.schedule;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Schedule;
import com.salon.service.ScheduleService;



@SpringBootTest
class SelectAllTests {
	
	@Autowired
	ScheduleService service;

	@Test
	void contextLoads() {
		List<Schedule> shd = null;
		try {
			shd = service.get();
			for(Schedule d:shd) {
				System.out.println(d);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

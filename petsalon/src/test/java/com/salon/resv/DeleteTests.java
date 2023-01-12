package com.salon.resv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ResvService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		try {
			service.remove(1001);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}
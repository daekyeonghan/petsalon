package com.salon.resv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		Resv resv = null;
		try {
			resv = service.get(1000);
			System.out.println(resv);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

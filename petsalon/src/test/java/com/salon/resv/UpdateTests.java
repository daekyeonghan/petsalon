package com.salon.resv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		Resv resv = new Resv(1001, "앞발이 예민해요", 0);
		try {
			service.modify(resv);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

package com.salon.resv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		Resv resv = new Resv(0, "ruler@naver.com", 2, "miyongsin1", 100, "잘 부탁드립니다", 0);
		try {
			service.register(resv);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			//e.printStackTrace();
		}
	}

}

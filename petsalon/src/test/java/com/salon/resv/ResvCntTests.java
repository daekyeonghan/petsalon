package com.salon.resv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ResvService;

@SpringBootTest
class ResvCntTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		int cnt = 0;
		
		try {
			cnt = service.resvcnt("ruler@naver.com");
			System.out.println(cnt);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

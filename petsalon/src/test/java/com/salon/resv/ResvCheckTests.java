package com.salon.resv;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class ResvCheckTests {

	@Autowired
	ResvService service;
	
	@Test
	void contextLoads() {
		
		List<Resv> obj;
		
		try {
			obj = service.resvcheck("kuro@naver.com");
			System.out.println(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

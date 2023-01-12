package com.salon.resv;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class SelectAllTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		List<Resv> resvs = null;
		try {
			resvs = service.get();
			for(Resv r:resvs) {
				System.out.println(r);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

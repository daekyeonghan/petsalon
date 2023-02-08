package com.salon.resv;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Resv;
import com.salon.service.ResvService;

@SpringBootTest
class ResvDelChkTests {
	
	@Autowired
	ResvService service;

	@Test
	void contextLoads() {
		List<Resv> list = null;
		try {
			list = service.resvdelchk("admintest@test.com");
			System.out.println(list);
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

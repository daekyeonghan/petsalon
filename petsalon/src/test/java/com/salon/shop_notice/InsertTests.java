package com.salon.shop_notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Shop_Notice;
import com.salon.service.Shop_NoticeService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	Shop_NoticeService service;

	@Test
	void contextLoads() {
		Shop_Notice sn = new Shop_Notice(0, "admin02", "테스트 추가", "테스트 추가", null);
		try {
			service.register(sn);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

package com.salon.shop_notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Shop_Notice;
import com.salon.service.Shop_NoticeService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	Shop_NoticeService service;

	@Test
	void contextLoads() {
		Shop_Notice sn = new Shop_Notice(5, "테스트수정", "테스트수정", "haro.jpg");
		try {
			service.modify(sn);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

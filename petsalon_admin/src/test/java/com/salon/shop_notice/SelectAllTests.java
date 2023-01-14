package com.salon.shop_notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Shop_Notice;
import com.salon.service.Shop_NoticeService;

@SpringBootTest
class SelectAllTests {
	
	@Autowired
	Shop_NoticeService service;

	@Test
	void contextLoads() {
		List<Shop_Notice> notices = null;
		try {
			notices = service.get();
			for(Shop_Notice s:notices) {
				System.out.println(s);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

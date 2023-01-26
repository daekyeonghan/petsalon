package com.salon.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ReviewService;

@SpringBootTest
class ReviewCntTests {
	
	@Autowired
	ReviewService reservice;

	@Test
	void contextLoads() {
		int cnt = 0;
		
		try {
			cnt = reservice.review_count("kuro@naver.com");
			System.out.println(cnt);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}

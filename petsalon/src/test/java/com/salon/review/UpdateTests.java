package com.salon.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review;
import com.salon.service.ReviewService;

@SpringBootTest
class UpdateTests {

	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
	Review obj = new Review(0, "test@test.com", "babo", "아주 좋군요", "베리굿", "good.jpg");
		
		try {
			service.modify(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

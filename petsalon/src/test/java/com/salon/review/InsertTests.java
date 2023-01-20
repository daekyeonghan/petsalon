package com.salon.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review;
import com.salon.service.ReviewService;

@SpringBootTest
class InsertTests {

	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		Review obj = new Review(0,"helloworld@gmail.com", "babo",3, "테스트제목", "테스트내용", null);
		
		try {
			service.register(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

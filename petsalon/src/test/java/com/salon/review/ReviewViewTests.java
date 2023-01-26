package com.salon.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review;
import com.salon.service.ReviewService;

@SpringBootTest
class ReviewViewTests {

	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<Review> objs = null;
		
		try {
			objs = service.reviewselect();
			System.out.println(objs);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

package com.salon.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review;
import com.salon.dto.User;
import com.salon.service.ReviewService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<Review> objs = null;
		
		try {
			objs = service.get();
			System.out.println(objs);
			for(Review obj : objs) {
				System.out.println(obj);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

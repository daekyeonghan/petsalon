package com.salon.review_answer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review_Answer;
import com.salon.service.Review_AnswerService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	Review_AnswerService service;
	
	@Test
	void contextLoads() {
		
		List<Review_Answer> objs = null;
		
		try {
			objs = service.get();
			for(Review_Answer obj : objs) {
				System.out.println(obj);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

package com.salon.review_answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review_Answer;
import com.salon.service.Review_AnswerService;

@SpringBootTest
class InsertTests {

	@Autowired
	Review_AnswerService service;
	
	@Test
	void contextLoads() {
		
		Review_Answer obj = new Review_Answer(0, "테스트", 2, "admin01", null);
		
		try {
			service.register(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

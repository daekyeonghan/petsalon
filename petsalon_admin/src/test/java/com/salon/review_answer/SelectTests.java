package com.salon.review_answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review_Answer;
import com.salon.service.Review_AnswerService;

@SpringBootTest
class SelectTests {

	@Autowired
	Review_AnswerService service;
	
	@Test
	void contextLoads() {
		
		Review_Answer obj;
		
		try {
			obj = service.get(1);
			System.out.println(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

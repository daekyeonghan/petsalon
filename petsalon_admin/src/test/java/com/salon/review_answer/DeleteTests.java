package com.salon.review_answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.Review_AnswerService;

@SpringBootTest
class DeleteTests {

	@Autowired
	Review_AnswerService service;
	
	@Test
	void contextLoads() {
		
		try {
			service.remove(5);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}

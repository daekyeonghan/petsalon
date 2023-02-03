package com.salon.review_answer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Review_Answer;
import com.salon.service.Review_AnswerService;

@SpringBootTest
class InsertTests2 {

	@Autowired
	Review_AnswerService raserviService;
	
	@Test
	void contextLoads() {
		
		Review_Answer rag= new Review_Answer(1,"테스트",1,"admin01",null);
		try {
			
			raserviService.register(rag);
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}

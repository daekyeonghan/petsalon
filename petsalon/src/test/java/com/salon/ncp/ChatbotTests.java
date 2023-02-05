package com.salon.ncp;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.frame.ChatBotUtil;

@SpringBootTest
class ChatbotTests {

	@Test
	void contextLoads() {
		String q = "지금뭐하니";
		String reply = null;
		
		try {
			reply = ChatBotUtil.chat(q);
			System.out.println(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

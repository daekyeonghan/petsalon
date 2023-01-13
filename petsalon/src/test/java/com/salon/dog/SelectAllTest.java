package com.salon.dog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Dog;
import com.salon.service.DogService;

@SpringBootTest
class SelectAllTest {
	
	@Autowired
	DogService service;
	
	@Test
	void contextLoads() {
		List list = null;
		try {
			list = service.get();
			System.out.println(list);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}

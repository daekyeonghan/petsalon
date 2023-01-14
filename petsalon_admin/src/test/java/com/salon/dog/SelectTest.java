package com.salon.dog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Dog;
import com.salon.service.DogService;

@SpringBootTest
class SelectTest {
	
	@Autowired
	DogService service;
	
	@Test
	void contextLoads() {
		Dog dog = null;
		try {
			dog = service.get(1);
			System.out.println(dog);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}

package com.salon.dog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Dog;
import com.salon.service.DogService;

@SpringBootTest
class InsertTest {
	
	@Autowired
	DogService service;
	
	@Test
	void contextLoads() {
		Dog dog = new Dog(0,"ruler@naver.com","나비","navi.img","F",5,11.4F,"사모예드","없습니다");
		try {
			service.register(dog);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}

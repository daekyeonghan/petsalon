package com.salon.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ItemService;

@SpringBootTest
class PagingTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		        int recordsPerPage = 6;
		        int totalPages = 0;

		    	try {
					int totalRecords = service.totalitem();
			        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("failed to get total pages");
				}
		    	
		    	System.out.println(totalPages);

	}

}

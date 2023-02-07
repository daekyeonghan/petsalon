package com.salon.resv;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Item;
import com.salon.dto.Resv;
import com.salon.service.ItemService;
import com.salon.service.ResvService;

@SpringBootTest
class ChartTests {
	

	@Autowired
	ResvService resvservice;
	
	@Autowired
	ItemService iservice;

	@Test
	void contextLoads() {

		List<Resv> resvlist = null;
		
		JSONArray finalChartData = new JSONArray();
		
		try {
			resvlist = resvservice.styleChart();

	
			
			List<Resv> subResvlist = null;
		
				
			
			
			
					
			for(Resv resv : resvlist) {
				subResvlist = resvservice.styleDogChart(resv.getItem_id());
				JSONObject obj = new JSONObject();
				JSONArray subChartData = new JSONArray();	
				JSONArray doglist = new JSONArray();
					for(int i = 0; i<subResvlist.size(); i++) {
					
						doglist.add(subResvlist.get(i).getDog_breed());
						doglist.add(subResvlist.get(i).getRatio());
					
					}
					
					for (int i = 0; i < doglist.size(); i+=2) {
			            JSONArray subArray = new JSONArray();
			            
			            subArray.add(doglist.get(i));
			            subArray.add(doglist.get(i+1));
			            subChartData.add(subArray);
			        }
					obj.put("name", resv.getItem_name());
					obj.put("id", resv.getItem_id());
					obj.put("data", subChartData);
					
					finalChartData.add(obj);
//					}
//					
//			        		[{name:'',id:'',data:[[],[],[],[],[]]},{},{},...]
//						

					
				//	System.out.println(finalChartData);
		}
			System.out.println(finalChartData);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
				
				
}}
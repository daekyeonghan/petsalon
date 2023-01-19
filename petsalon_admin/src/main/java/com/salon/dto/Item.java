package com.salon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {
	private int item_id;
	private String designer_id;
	private String item_name;
	private int item_price;
	private String item_photo;
	
	private String designer_name;


	// designer_name 추가 이전의 생성자
	public Item(int item_id, String designer_id, String item_name, int item_price, String item_photo) {
		super();
		this.item_id = item_id;
		this.designer_id = designer_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_photo = item_photo;
	}
	
	

}

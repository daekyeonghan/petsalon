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

public class Resv {
	private int resv_no;
	private String useremail;
	private int dog_id;
	private String designer_id;
	private int item_id;
	private String resv_ask;
	private int resv_fix;
	
	public Resv(int resv_no, String resv_ask, int resv_fix) {
		super();
		this.resv_no = resv_no;
		this.resv_ask = resv_ask;
		this.resv_fix = resv_fix;
	}
	
	
	
	
}
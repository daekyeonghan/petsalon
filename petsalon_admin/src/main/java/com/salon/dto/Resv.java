package com.salon.dto;

import java.util.Date;

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

	private String cancel;
	
	private String username;
	private String dog_name;
	private String designer_name;
	private String item_name;
	
	private Date sc_date;
	
	public Resv(int resv_no, String resv_ask, int resv_fix) {
		super();
		this.resv_no = resv_no;
		this.resv_ask = resv_ask;
		this.resv_fix = resv_fix;
	}


	public Resv(int resv_no, String useremail, int dog_id, String designer_id, int item_id, String resv_ask,
			int resv_fix) {
		this.resv_no = resv_no;
		this.useremail = useremail;
		this.dog_id = dog_id;
		this.designer_id = designer_id;
		this.item_id = item_id;
		this.resv_ask = resv_ask;
		this.resv_fix = resv_fix;
	}
	
	
	
	
}

package com.salon.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Schedule {
	private int sc_id;
	private String designer_id;
	private int resv_no;
	private Date sc_date;
	
	public Schedule(int sc_id, String designer_id, int resv_no) {
		this.sc_id = sc_id;
		this.designer_id = designer_id;
		this.resv_no = resv_no;
		
	}
}


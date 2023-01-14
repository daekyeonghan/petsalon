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

public class Shop_Notice {
	private int sn_no;
	private String admin_id;
	private String sn_title;
	private String sn_content;
	private String sn_photo;
	private Date sn_rdate;
	
	public Shop_Notice(int sn_no, String admin_id, String sn_title, String sn_content, String sn_photo) {
		super();
		this.sn_no = sn_no;
		this.admin_id = admin_id;
		this.sn_title = sn_title;
		this.sn_content = sn_content;
		this.sn_photo = sn_photo;
	}

	public Shop_Notice(int sn_no, String sn_title, String sn_content, String sn_photo) {
		super();
		this.sn_no = sn_no;
		this.sn_title = sn_title;
		this.sn_content = sn_content;
		this.sn_photo = sn_photo;
	}
	
	


	

}

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
public class Designer {
	private String designer_id;
	private String admin_id;
	private String designer_name;
	private int designer_career;
	private String designer_introduce;
	private String designer_photo;
	private Date designer_date;
	
	private String item_name;

	public Designer(String designer_id, String admin_id, String designer_name, int designer_career,
			String designer_introduce, String designer_photo, Date designer_date) {
		super();
		this.designer_id = designer_id;
		this.admin_id = admin_id;
		this.designer_name = designer_name;
		this.designer_career = designer_career;
		this.designer_introduce = designer_introduce;
		this.designer_photo = designer_photo;
		this.designer_date = designer_date;
	}
}

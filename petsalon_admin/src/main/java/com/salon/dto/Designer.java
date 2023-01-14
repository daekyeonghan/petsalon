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
}

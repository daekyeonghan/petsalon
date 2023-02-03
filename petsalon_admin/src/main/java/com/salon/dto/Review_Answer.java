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
public class Review_Answer {
	private int ra_no;
	private String ra_content;
	private int review_no;
	private String admin_id;
	private Date ra_date;
	
	public Review_Answer(int ra_no, String ra_content) {
		super();
		this.ra_no = ra_no;
		this.ra_content = ra_content;
	}

	/**
	 * @param ra_content
	 * @param review_no
	 * @param admin_id
	 */
	public Review_Answer(int ra_no, String ra_content, int review_no, String admin_id) {
		this.ra_no = ra_no;
		this.ra_content = ra_content;
		this.review_no = review_no;
		this.admin_id = admin_id;
	}
	
	
	
	
	
	
}

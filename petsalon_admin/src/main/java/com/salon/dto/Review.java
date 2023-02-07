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
public class Review {
	private int review_no;
	private String useremail;
	private String designer_id;
	private String review_title;
	private int dog_id;
	private String review_content;
	private String review_photo;
	private Date review_date;
	private int resv_no;
	
	
	// reviewmapper.xml INSERT 문 review_date 를 NOW()로 들어가게 해놔서 review_date를 뺀 생성자입니다. 불필요시 삭제해주세요.
	public Review(int review_no, String useremail, String designer_id, String review_title, String review_content,
			String review_photo) {
		super();
		this.review_no = review_no;
		this.useremail = useremail;
		this.designer_id = designer_id;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_photo = review_photo;
	}

	
	
	
}

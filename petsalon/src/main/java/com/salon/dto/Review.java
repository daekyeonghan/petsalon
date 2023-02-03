package com.salon.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
	private String dog_id;
	private String review_title;
	private String review_content;
	private String review_photo;
	private Date review_date;
	private int resv_no;
	
	private String designer_name;
	private String dog_name;
	
	private int review_count;
	
	private MultipartFile review_img;
	
	
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


	public Review(String review_title, String designer_name, String dog_name) {
		super();
		this.review_title = review_title;
		this.designer_name = designer_name;
		this.dog_name = dog_name;
	}

	// 리뷰 뷰페이지 쓰려고만듦
	public Review(int review_no, String useremail, String review_title, String review_content, String review_photo,
			Date review_date, String designer_name, String dog_name) {
		super();
		this.review_no = review_no;
		this.useremail = useremail;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_photo = review_photo;
		this.review_date = review_date;
		this.designer_name = designer_name;
		this.dog_name = dog_name;
	}
	
	
	
	
	
}

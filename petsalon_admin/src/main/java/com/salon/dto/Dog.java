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
public class Dog {
	private int dog_id;
	private String useremail;
	private String dog_name;
	private String dog_photo;
	private String dog_gender;
	private int dog_age;
	private float dog_weight;
	private String dog_breed;
	private String dog_special;
	private Date dog_rdate;
	
	public Dog(int dog_id, String useremail, String dog_name, String dog_photo, String dog_gender, int dog_age,
			float dog_weight, String dog_breed, String dog_special) {
		super();
		this.dog_id = dog_id;
		this.useremail = useremail;
		this.dog_name = dog_name;
		this.dog_photo = dog_photo;
		this.dog_gender = dog_gender;
		this.dog_age = dog_age;
		this.dog_weight = dog_weight;
		this.dog_breed = dog_breed;
		this.dog_special = dog_special;
	}
	
}

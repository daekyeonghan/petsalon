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
public class User {
	private String useremail;
	private String userpwd;
	private String username; 
	private String birth; 
	private String tel;
	private String addr;
	private String detaddr;
	private String zipcode;
	private Date rdate;
	private String searchValue;
	private String checkRow;
	
	// usermapper.xml 의 INSERT 쿼리문에서 rdate를 무조건 NOW()로 들어가게 해놔서 rdate를 제외한 생성자를 만들었습니다. 필요없어질 시 삭제해주세요. 
	public User(String useremail, String userpwd, String username, String birth, String tel, String addr, String detaddr,
			String zipcode) {
		super();
		this.useremail = useremail;
		this.userpwd = userpwd;
		this.username = username;
		this.birth = birth;
		this.tel = tel;
		this.addr = addr;
		this.zipcode = zipcode;
	}

	/**
	 * @param useremail
	 * @param userpwd
	 * @param username
	 * @param birth
	 * @param tel
	 * @param addr
	 * @param detaddr
	 * @param zipcode
	 * @param rdate
	 */
	public User(String useremail, String userpwd, String username, String birth, String tel, String addr,
			String detaddr, String zipcode, Date rdate) {
		this.useremail = useremail;
		this.userpwd = userpwd;
		this.username = username;
		this.birth = birth;
		this.tel = tel;
		this.addr = addr;
		this.detaddr = detaddr;
		this.zipcode = zipcode;
		this.rdate = rdate;
	}
	
	
	
	
	
}



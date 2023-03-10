package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.User;
import com.salon.frame.MyService;
import com.salon.mapper.UserMapper;

@Service
public class UserService implements MyService<String, User>{

	@Autowired
	UserMapper mapper;
	
	@Override
	public void register(User v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(User v) throws Exception {
		mapper.update(v);
	}

	@Override
	public User get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<User> get() throws Exception {
		return mapper.selectall();
	}
	
	public String findemail(String k, String j) throws Exception{
		return mapper.findemail(k, j);
	}
	
	public String findpwd(String k) throws Exception{
		return mapper.findpwd(k);
	}
	
	public int checkId(String useremail) {
		int result = mapper.checkId(useremail);
		return result;
	}
	
	public int findpwdcorrect(String username, String tel, String useremail) {
		return mapper.findpwdcorrect(username, tel, useremail);
	}
	
	public void resetpwd(String userpwd, String useremail) throws Exception {
		mapper.resetpwd(userpwd, useremail);
	}
	

}

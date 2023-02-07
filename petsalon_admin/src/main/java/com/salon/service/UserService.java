package com.salon.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.User;
import com.salon.frame.MyService;
import com.salon.mapper.UserMapper;

@Service
public class UserService  implements MyService<String, User>{

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
	
	public List<User> usersearch(String k) throws Exception {
		return mapper.usersearch(k);
	}

	public List<User> detailselect(String useremail)throws Exception{
		return mapper.detailselect(useremail);
	}

	public List<User> paginguser(Integer paging, Integer offset)throws Exception {
		return mapper.paginguser(paging,offset);
	}

	public int totaluser() throws Exception {
		return mapper.totaluser();
	}
}

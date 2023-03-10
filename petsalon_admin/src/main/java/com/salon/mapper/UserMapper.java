package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.User;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, User>{

	public  List<User> usersearch(String word)throws Exception;
	public void remove(String useremail);
	public List<User> detailselect(String useremail)throws Exception;
	public List<User> paginguser(int paging, int offset);
	public Integer totaluser() throws Exception;
}

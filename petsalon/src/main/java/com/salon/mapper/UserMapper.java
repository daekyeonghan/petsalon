package com.salon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.User;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, User>{
	public String findemail(String username, String tel);
	public String findpwd(String useremail);
}

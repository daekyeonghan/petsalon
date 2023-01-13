package com.salon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Admin;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, Admin> {

}

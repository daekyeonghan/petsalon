package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Resv;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ResvMapper extends MyMapper<Integer, Resv>{

	public List<Resv> notFixed() throws Exception;
	
	public List<Resv> selectlist() throws Exception;
}

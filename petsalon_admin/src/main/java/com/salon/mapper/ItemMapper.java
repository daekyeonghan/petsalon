package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Item;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, Item> {

	public List<Item> selectmenu() throws Exception;
	
}

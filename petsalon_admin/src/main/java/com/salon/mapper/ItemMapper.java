package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Item;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, Item> {

	public List<Item> dsMenu(String designer_id) throws Exception;
	
	public List<Item> sortitem(String designer_id, int limit, int offset) throws Exception;
	
	public List<Item> pagingitem(Integer limit, Integer offset) throws Exception;
	
	public Integer totalitem() throws Exception;
	
	public Integer totaldsitem(String designer_id) throws Exception;
}

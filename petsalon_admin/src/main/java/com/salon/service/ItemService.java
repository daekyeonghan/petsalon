package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Item;
import com.salon.frame.MyService;
import com.salon.mapper.ItemMapper;

@Service
public class ItemService implements MyService<Integer, Item>{
	@Autowired
	ItemMapper mapper;
	
	@Override
	public void register(Item v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Item v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Item get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Item> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<Item> dsMenu(String designer_id) throws Exception{
		return mapper.dsMenu(designer_id);
	}
	
	public List<Item> sortitem(String id, Integer limit, Integer offset) throws Exception{
		return mapper.sortitem(id, limit, offset);
	}
	
	public List<Item> pagingitem(Integer limit, Integer offset) throws Exception{
		return mapper.pagingitem(limit, offset);
	}
	
	public Integer totalitem() throws Exception{
		return mapper.totalitem();
	}
	
	public Integer totaldsitem(String designer_id) throws Exception{
		return mapper.totaldsitem(designer_id);
	}


}

package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Shop_Notice;
import com.salon.frame.MyService;
import com.salon.mapper.Shop_NoticeMapper;

@Service
public class Shop_NoticeService implements MyService<Integer, Shop_Notice>{

	@Autowired
	Shop_NoticeMapper mapper;

	@Override
	public void register(Shop_Notice v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Shop_Notice v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Shop_Notice get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Shop_Notice> get() throws Exception {
		return mapper.selectall();
	}
	
	

}

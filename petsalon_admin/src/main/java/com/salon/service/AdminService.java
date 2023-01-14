package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Admin;
import com.salon.frame.MyService;
import com.salon.mapper.AdminMapper;

@Service
public class AdminService implements MyService<String, Admin>{
	@Autowired
	AdminMapper mapper;
	
	@Override
	public void register(Admin v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Admin v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Admin get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Admin> get() throws Exception {
		return mapper.selectall();
	}

}

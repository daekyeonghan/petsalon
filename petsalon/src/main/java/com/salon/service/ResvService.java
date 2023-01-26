package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Resv;
import com.salon.frame.MyService;
import com.salon.mapper.ResvMapper;

@Service
public class ResvService implements MyService<Integer, Resv>{

	@Autowired
	ResvMapper mapper;

	@Override
	public void register(Resv v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Resv v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Resv get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Resv> get() throws Exception {
		return mapper.selectall();
	}

	public List<Resv> userResv(String j) throws Exception {
		return mapper.userResv(j);
	}
	
	public int resvcnt(String useremail) throws Exception {
		return mapper.resvcnt(useremail);
	}
}

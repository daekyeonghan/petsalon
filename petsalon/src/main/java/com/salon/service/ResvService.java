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
	
	public List<Resv> visit(String j) throws Exception {
		return mapper.visit(j);
	}
	
	public List<Resv> emailselect(String useremail) throws Exception{
		return mapper.emailselect(useremail);
	}
	
	public List<Resv> resvcheck(String useremail) throws Exception {
		return mapper.resvcheck(useremail);
	}
	
	public int resvnoSelect() throws Exception {
		return mapper.resvnoSelect();
	}
	
	public List<Resv> resvdelchk(String useremail) throws Exception {
		return mapper.resvdelchk(useremail);
	}
}

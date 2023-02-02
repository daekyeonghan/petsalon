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
	
	public List<Resv> notFixed() throws Exception{
		return mapper.notFixed();
	}
	
	public Resv selectList(Integer resv_no) throws Exception{
		return mapper.selectList(resv_no);
	}

	public List<Resv> resvList() throws Exception{
		return mapper.resvList();
	}

	public List<Resv> scheduleList() throws Exception{
		return mapper.scheduleList();
	}

	public List<Resv> dsScheduleList(String designer_id) throws Exception{
		return mapper.dsScheduleList(designer_id);
	}
	
	public void resvFixUpdate(int resv_no, int resv_fix) throws Exception{
		mapper.resvFixUpdate(resv_no, resv_fix);
	}
}

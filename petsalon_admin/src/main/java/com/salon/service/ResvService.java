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

	public List<Resv> resvList(Integer limit, Integer offset) throws Exception{
		return mapper.resvList(limit, offset);
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
	
	public void resvCancel(int resv_no, String cancel) throws Exception{
		mapper.resvCancel(resv_no, cancel);
	}
	
	public int resvMonthChart(Integer chartYear, Integer chartMonth, Integer resv_fix) throws Exception{
		return mapper.resvMonthChart(chartYear, chartMonth, resv_fix);
	}
	
	public List<Resv> styleChart() throws Exception{
		return mapper.styleChart();
	}
	
	public List<Resv> styleDogChart(Integer item_id) throws Exception{
		return mapper.styleDogChart(item_id);
	}
	
	public List<Resv> userChart() throws Exception{
		return mapper.userChart();
	}
	
	public List<Resv> userResvChart(Integer resv_fix) throws Exception{
		return mapper.userResvChart(resv_fix);
	}
	
	public List<Resv> designerChart(Integer resv_fix) throws Exception{
		return mapper.designerChart(resv_fix);
	}
	
	public List<Resv> designerItemChart(String designer_id) throws Exception{
		return mapper.designerItemChart(designer_id);
	}
}

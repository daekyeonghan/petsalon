package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Schedule;
import com.salon.frame.MyService;
import com.salon.mapper.ScheduleMapper;

@Service
public class ScheduleService implements MyService<Integer, Schedule> {

	@Autowired
	ScheduleMapper mapper;

	@Override
	public void register(Schedule v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Schedule v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Schedule get(Integer k) throws Exception {
		
		return mapper.select(k);
	}

	@Override
	public List<Schedule> get() throws Exception {
		
		return mapper.selectall();
	}

	public List<Schedule> dsSchedule(String designer_id) throws Exception{
		return mapper.dsSchedule(designer_id);
	}
	
	public void scheduleDel(Integer sc_id) throws Exception{
		mapper.scheduleDel(sc_id);
	}
	
	public List<Schedule> dateData(String chartYear,String chartMonth) throws Exception{
		return mapper.dateData(chartYear, chartMonth);
	}
	
	

}

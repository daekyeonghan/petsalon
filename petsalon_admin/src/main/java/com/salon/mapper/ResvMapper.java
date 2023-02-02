package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Resv;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ResvMapper extends MyMapper<Integer, Resv>{

	public List<Resv> notFixed() throws Exception;
	
	public Resv selectList(Integer resv_no) throws Exception;
	
	public List<Resv> resvList() throws Exception;

	public List<Resv> scheduleList() throws Exception;
	
	public List<Resv> dsScheduleList(String designer_id) throws Exception;
	
	public void resvFixUpdate(int resv_no, int resv_fix) throws Exception;
}

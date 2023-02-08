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
	
	public List<Resv> resvList(Integer limit, Integer offset) throws Exception;

	public List<Resv> scheduleList() throws Exception;
	
	public List<Resv> dsScheduleList(String designer_id) throws Exception;
	
	public void resvFixUpdate(Integer resv_no, Integer resv_fix) throws Exception;
	
	public void resvCancel(Integer resv_no, String cancel) throws Exception;
	
	public int resvMonthChart(Integer chartYear, Integer chartMonth, Integer resv_fix) throws Exception;
	
	public List<Resv> styleChart() throws Exception;
	
	public List<Resv> styleDogChart(Integer item_id) throws Exception;
	
	public List<Resv> userChart() throws Exception;
	
	public List<Resv> userResvChart(Integer resv_fix) throws Exception;
	
	public List<Resv> designerChart(Integer resv_fix) throws Exception;
	
	public List<Resv> designerItemChart(String designer_id) throws Exception;
	
	/* daekyeong add */
	public Resv mailinformation(Integer resv_no) throws Exception;
}

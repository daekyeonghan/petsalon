package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Schedule;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ScheduleMapper extends MyMapper<Integer,Schedule>{

	public List<Schedule> dsSchedule(String designer_id) throws Exception;
}

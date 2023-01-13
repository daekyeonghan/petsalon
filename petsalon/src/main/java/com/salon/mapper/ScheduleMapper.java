package com.salon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Schedule;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ScheduleMapper extends MyMapper<Integer,Schedule>{

}

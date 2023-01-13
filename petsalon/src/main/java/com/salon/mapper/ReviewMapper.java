package com.salon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Review;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, Review>{

}

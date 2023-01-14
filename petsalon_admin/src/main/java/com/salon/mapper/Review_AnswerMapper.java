package com.salon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Review_Answer;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface Review_AnswerMapper extends MyMapper<Integer, Review_Answer>{

}

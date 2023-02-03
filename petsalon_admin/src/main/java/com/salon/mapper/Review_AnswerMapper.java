package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Review_Answer;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface Review_AnswerMapper extends MyMapper<Integer, Review_Answer>{
	public List<Review_Answer> adminreview(Integer review_no);
	public void remove(Integer ra_no);
}

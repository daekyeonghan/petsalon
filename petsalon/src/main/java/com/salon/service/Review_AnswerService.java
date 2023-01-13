package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Review_Answer;
import com.salon.frame.MyService;
import com.salon.mapper.Review_AnswerMapper;

@Service
public class Review_AnswerService implements MyService<Integer, Review_Answer>{

	@Autowired
	Review_AnswerMapper mapper;

	@Override
	public void register(Review_Answer v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Review_Answer v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Review_Answer get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Review_Answer> get() throws Exception {
		return mapper.selectall();
	}
	
	
}

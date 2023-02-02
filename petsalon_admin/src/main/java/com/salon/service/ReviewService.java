package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Review;
import com.salon.frame.MyService;
import com.salon.mapper.ReviewMapper;

@Service
public class ReviewService implements MyService<Integer, Review>{

	@Autowired
	ReviewMapper mapper;
	
	
	@Override
	public void register(Review v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Review v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Review get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Review> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<Review> onedayReivew() throws Exception{
		return mapper.onedayReivew();
	}

}

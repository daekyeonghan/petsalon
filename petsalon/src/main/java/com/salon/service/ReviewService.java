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
	
	public List<Review> reviewselect() throws Exception {
		return mapper.reviewselect();
	}
	
	public int reviewDelete(int review_no) throws Exception {
		return mapper.reviewDelete(review_no);
	}
	
	public int review_count(String useremail) throws Exception {
		return mapper.review_count(useremail);
	}
	
	public void nopicUpdate(Review v) throws Exception {
		mapper.nopicUpdate(v);
	}
	
	public List<Review> selectload(String useremail) throws Exception {
		return mapper.selectload(useremail);
	}
	
	public List<Review> searchreview(String designer_id) throws Exception {
		return mapper.searchreview(designer_id);
	}
	
	public List<Review> notnullreview() throws Exception {
		return mapper.notnullreview();
	}
	
	public Review reviewcount(Integer resv_no) throws Exception {
		return mapper.reviewcount(resv_no);
	}

}

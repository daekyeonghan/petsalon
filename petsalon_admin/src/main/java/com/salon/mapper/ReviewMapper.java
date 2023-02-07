package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Item;
import com.salon.dto.Review;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, Review>{

	public List<Review> onedayReivew() throws Exception;

	public List<Review> pagingreview(Integer limit, Integer offset) throws Exception;

	public List<Review> reviewsearch(String word)throws Exception;
	
	public List<Review> pagingreview1(int paging, int offset);

	public Integer totalreview()throws Exception;

}

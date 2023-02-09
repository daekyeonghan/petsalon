package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Review;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, Review>{
	//리뷰 페이지 뿌려줄때
	public List<Review> reviewselect() throws Exception;
	public int reviewDelete(int review_no) throws Exception;
	public int review_count(String useremail) throws Exception;
	public void nopicUpdate(Review review) throws Exception;
	public List<Review> selectload(String useremail) throws Exception;
	public List<Review> searchreview(String designer_id) throws Exception;
	public List<Review> notnullreview() throws Exception;
	public Review reviewcount(Integer resv_no) throws Exception;

}

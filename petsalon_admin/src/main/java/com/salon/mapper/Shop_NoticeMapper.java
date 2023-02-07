package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Shop_Notice;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface Shop_NoticeMapper extends MyMapper<Integer, Shop_Notice>{

	public List<Shop_Notice> noticePaging(Integer limit, Integer offset) throws Exception;
}

package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Dog;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface DogMapper extends MyMapper<Integer, Dog> {
	public List<Dog> ownerdog(String useremail);
}

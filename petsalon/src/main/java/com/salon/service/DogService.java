package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Dog;
import com.salon.frame.MyService;
import com.salon.mapper.DogMapper;

@Service
public class DogService implements MyService<Integer, Dog>{
	@Autowired
	DogMapper mapper;
	
	@Override
	public void register(Dog v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Dog v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Dog get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Dog> get() throws Exception {
		return mapper.selectall();
	}

}

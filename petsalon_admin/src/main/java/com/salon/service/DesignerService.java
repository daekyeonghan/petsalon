package com.salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.dto.Designer;
import com.salon.frame.MyService;
import com.salon.mapper.DesignerMapper;

@Service
public class DesignerService<V> implements MyService<String, Designer>  {

		@Autowired
		DesignerMapper mapper;

		@Override
		public void register(Designer v) throws Exception {
			mapper.insert(v);
			
		}

		@Override
		public void remove(String k) throws Exception {
			mapper.delete(k);
		}

		@Override
		public void modify(Designer v) throws Exception {
			mapper.update(v);
			
		}

		@Override
		public Designer get(String k) throws Exception {
			
			return mapper.select(k);
		}

		@Override
		public List<Designer> get() throws Exception {
			
			return mapper.selectall();
		}

}

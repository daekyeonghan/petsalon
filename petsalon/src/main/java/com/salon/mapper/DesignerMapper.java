package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Designer;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface DesignerMapper extends MyMapper<String, Designer> {
	public List<Designer> designerItem();
}

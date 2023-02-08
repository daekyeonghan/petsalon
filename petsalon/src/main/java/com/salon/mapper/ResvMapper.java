package com.salon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.salon.dto.Resv;
import com.salon.frame.MyMapper;

@Repository
@Mapper
public interface ResvMapper extends MyMapper<Integer, Resv>{
	public List<Resv> userResv(String useremail);
	public int resvcnt(String useremail) throws Exception;
	public List<Resv> visit(String useremail);
	public List<Resv> emailselect(String useremail) throws Exception;
	public List<Resv> resvcheck(String useremail) throws Exception;
	public int resvnoSelect() throws Exception;
	public List<Resv> resvdelchk(String useremail) throws Exception;
}

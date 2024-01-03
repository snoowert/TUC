package com.spring.dao;

import java.util.List;

import com.spring.dto.LikeTableVO;

public interface LikeTableDAO {
	List<LikeTableVO> selectLikeList() throws Exception;
	
}

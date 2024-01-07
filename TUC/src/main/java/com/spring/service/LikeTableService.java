package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.LikeTableVO;

public interface LikeTableService {
	List<LikeTableVO> list() throws SQLException;
	
	LikeTableVO select(LikeTableVO like) throws SQLException;
	
	int listByBoard(String boardId) throws SQLException;
	
	void insert(LikeTableVO like) throws SQLException;
	
	void delete(LikeTableVO like) throws SQLException;
}

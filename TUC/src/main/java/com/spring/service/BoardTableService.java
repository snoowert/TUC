package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardTableVO;

public interface BoardTableService {
	List<BoardTableVO> list() throws SQLException;
	
	BoardTableVO select(String id) throws SQLException;

	void insert(BoardTableVO boardTable) throws SQLException;
	
	void update(BoardTableVO boardTable) throws SQLException;
	
	void delete(String Category) throws SQLException;
}

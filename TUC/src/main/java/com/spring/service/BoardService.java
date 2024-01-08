package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardVO;

public interface BoardService {
	List<BoardVO> list() throws SQLException;
	
	BoardVO select(BoardVO board) throws SQLException;
	
	void insert(BoardVO board) throws SQLException;
	
	void update(BoardVO board) throws SQLException;
	
	void delete(BoardVO board) throws SQLException;
}

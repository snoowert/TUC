package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardTableVO;

public interface BoardTableDAO {
	List<BoardTableVO> selectBoardTable() throws SQLException;

	BoardTableVO selectBoardTableById(String id) throws SQLException;

	void insertBoardTable(BoardTableVO boardtable) throws SQLException;

	void updateBoardTable(BoardTableVO boardtable) throws SQLException;

	void deleteBoardTable(String category) throws SQLException;

}

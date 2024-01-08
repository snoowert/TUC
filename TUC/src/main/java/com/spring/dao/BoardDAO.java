package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws SQLException;

	BoardVO selectBoardById(BoardVO board) throws SQLException;

	void insertBoard(BoardVO board) throws SQLException;

	void updateBoard(BoardVO board) throws SQLException;

	void deleteBoard(BoardVO board) throws SQLException;
}

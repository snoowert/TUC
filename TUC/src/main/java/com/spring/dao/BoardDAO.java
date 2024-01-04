package com.spring.dao;

import java.util.List;

import com.spring.dto.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws Exception;

	BoardVO selectBoardById(BoardVO board) throws Exception;

	void insertBoard(BoardVO board) throws Exception;

	void updateBoard(BoardVO board) throws Exception;

	void deleteBoard(BoardVO board) throws Exception;
}

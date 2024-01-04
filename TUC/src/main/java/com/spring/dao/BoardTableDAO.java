package com.spring.dao;

import java.util.List;

import com.spring.dto.BoardTableVO;

public interface BoardTableDAO {
	List<BoardTableVO> selectBoardTable() throws Exception;

	BoardTableVO selectBoardTableById(String id) throws Exception;

	void insertBoardTable(BoardTableVO boardtable) throws Exception;

	void updateBoardTable(BoardTableVO boardtable) throws Exception;

	void deleteBoardTable(String category) throws Exception;

}

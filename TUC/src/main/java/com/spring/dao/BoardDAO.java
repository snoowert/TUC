package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectRecipeList(PageMaker pagemaker) throws SQLException;

	int selectRecipeListCount() throws SQLException;
	
	int selectRecipeSeqNext() throws SQLException;
	
	BoardVO selectRecipeById(int boardid) throws SQLException;

	void insertRecipe(BoardVO board) throws SQLException;

	void updateRecipe(BoardVO board) throws SQLException;

	void increaseViewCount(int boardid) throws SQLException;
	
	void tempDeleteRecipe(int boardid) throws SQLException;
	
	void rewindRecipe(int boardid) throws SQLException;
	
	void deleteRecipe(int boardid) throws SQLException;
	
}

package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.CommentTableVO;

public interface CommentTableDAO {
	List<CommentTableVO> selectCommentList() throws SQLException;

	List<CommentTableVO> selectCommentById(String username) throws SQLException;

	List<CommentTableVO> selectCommentByBoard(String boardId) throws SQLException;
	
	void insertComment(CommentTableVO comment) throws SQLException;

	void updateComment(CommentTableVO comment) throws SQLException;

	void deleteComment(CommentTableVO comment) throws SQLException;
}

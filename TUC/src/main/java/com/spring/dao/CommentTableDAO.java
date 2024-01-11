package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.CommentTableVO;

public interface CommentTableDAO {

	CommentTableVO selectCommentById(String commentid) throws SQLException;
	
	List<CommentTableVO> selectCommentByBoard(int boardid) throws SQLException;
	
	void insertComment(CommentTableVO comment) throws SQLException;

	void updateComment(CommentTableVO comment) throws SQLException;

	void deleteComment(String commentid) throws SQLException;
}

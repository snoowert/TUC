package com.spring.dao;

import java.util.List;

import com.spring.dto.CommentTableVO;

public interface CommentTableDAO {
	List<CommentTableVO> selectCommentList() throws Exception;

	CommentTableVO selectCommentById(String username) throws Exception;

	void insertComment(CommentTableVO comment) throws Exception;

	void updateComment(CommentTableVO comment) throws Exception;

	void deleteComment(CommentTableVO comment) throws Exception;
}

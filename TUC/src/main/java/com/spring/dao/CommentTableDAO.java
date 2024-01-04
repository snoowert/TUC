package com.spring.dao;

public interface CommentTableDAO {
	List<CommentTableVO> selectCommentList() throws Exception;

	CommentTableVO selectCommentById(String id) throws Exception;

	void insertComment(CommentTableVO comment) throws Exception;

	void updateComment(CommentTableVO comment) throws Exception;

	void deleteComment(CommentTableVO comment) throws Exception;
}

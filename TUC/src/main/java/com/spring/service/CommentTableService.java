package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.CommentTableVO;


public interface CommentTableService {
	List<CommentTableVO> list() throws SQLException;

	List<CommentTableVO> detailByUser(String username) throws SQLException;

	List<CommentTableVO> detailByBoard(String boardid) throws SQLException;
	
	void regist(CommentTableVO comment) throws SQLException;

	void modify(CommentTableVO comment) throws SQLException;

	void remove(CommentTableVO comment) throws SQLException;
}

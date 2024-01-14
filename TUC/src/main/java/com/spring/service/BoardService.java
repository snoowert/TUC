package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;
import com.spring.dto.CommentTableVO;

public interface BoardService {

	// 목록
	List<BoardVO> list(PageMaker pagemaker) throws SQLException;

	// 등록
	void regist(BoardVO recipe) throws SQLException;

	// 읽기
	BoardVO read(int boardid) throws SQLException;

	// 수정
	void modify(BoardVO recipe) throws SQLException;

	// 삭제
	void delete(int boardid) throws SQLException;

	//댓글 읽기
	CommentTableVO readComment(String commentid) throws SQLException;
	
	// 댓글등록
	void registComment(CommentTableVO comment, int boardid) throws SQLException;
	
	// 댓글수정
	void modifyComment(CommentTableVO comment) throws SQLException;

	// 댓글삭제
	void deleteComment(String commentid) throws SQLException;
}

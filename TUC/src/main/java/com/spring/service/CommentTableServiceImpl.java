package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.CommentTableDAO;
import com.spring.dto.CommentTableVO;

public class CommentTableServiceImpl implements CommentTableService {
	private CommentTableDAO commentDAO;

	public void setMemberDAO(CommentTableDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	public List<CommentTableVO> list() throws SQLException {
		// TODO Auto-generated method stub
		return commentDAO.selectCommentList();
	}

	@Override
	public List<CommentTableVO> detailByUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		return commentDAO.selectCommentById(username);
	}

	@Override
	public List<CommentTableVO> detailByBoard(String boardid) throws SQLException {
		// TODO Auto-generated method stub
		return commentDAO.selectCommentByBoard(boardid);
	}

	@Override
	public void regist(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		commentDAO.insertComment(comment);
	}

	@Override
	public void modify(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		commentDAO.updateComment(comment);
	}

	@Override
	public void remove(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		commentDAO.deleteComment(comment);
	}

	

}

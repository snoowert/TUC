package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.CommentTableVO;

public class CommentTableDAOImpl implements CommentTableDAO {

	private SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public CommentTableVO selectCommentById(String commentid) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("CommentTable-Mapper.selectCommentById", commentid);
	}

	@Override
	public List<CommentTableVO> selectCommentByBoard(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("CommentTable-Mapper.selectCommentByBoard", boardid);
	}

	@Override
	public void insertComment(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("CommentTable-Mapper.insertComment", comment);
	}

	@Override
	public void updateComment(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		session.update("CommentTable-Mapper.updateComment", comment);
	}

	@Override
	public void deleteComment(String commentid) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("CommentTable-Mapper.deleteComment", commentid);
	}

}

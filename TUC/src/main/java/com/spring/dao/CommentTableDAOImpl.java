package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.CommentTableVO;

public class CommentTableDAOImpl implements CommentTableDAO {

	private SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<CommentTableVO> selectCommentList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("CommentTable-Mapper.selectCommentList");
	}

	@Override
	public CommentTableVO selectCommentById(String username) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("CommentTable-Mapper.selectCommentById",username);
	}

	@Override
	public void insertComment(CommentTableVO comment) throws Exception {
		// TODO Auto-generated method stub
		session.insert("CommentTable-Mapper.insertComment", comment);
	}

	@Override
	public void updateComment(CommentTableVO comment) throws Exception {
		// TODO Auto-generated method stub
		session.update("CommentTable-Mapper.updateComment",comment);
	}

	@Override
	public void deleteComment(CommentTableVO comment) throws Exception {
		// TODO Auto-generated method stub
		session.delete("CommentTable-Mapper.deleteComment",comment);
	}

}

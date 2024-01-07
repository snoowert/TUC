package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.LikeTableVO;

public class LikeTableDAOImpl implements LikeTableDAO {

	SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<LikeTableVO> selectLikeList() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("LikeTable-Mapper.selectLikeList");
	}

	@Override
	public LikeTableVO selectLikeById(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("LikeTable-Mapper.selectLikeById", like);
	}

	@Override
	public int selectLikeListByBoard(String boardId) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("LikeTable-Mapper.selectLikeListByBoard", boardId);
	}

	@Override
	public void insertLike(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("LikeTable-Mapper.insertLike", like);
	}

	@Override
	public void deleteLike(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("LikeTable-Mapper.insertLike", like);
	}

}

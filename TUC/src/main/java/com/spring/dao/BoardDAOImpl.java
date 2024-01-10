package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("Board-Mapper.selectBoardList");
	}
	
	@Override
	public List<BoardVO> selectBoardByCategory(String Category) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("Board-Mapper.selectBoardByCategory",Category);
	}
	
	@Override
	public BoardVO selectBoardById(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("Board-Mapper.selectBoardById");
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("Board-Mapper.insertBoard");
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		session.update("Board-Mapper.updateBoard", board);
	}

	@Override
	public void deleteBoard(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("Board-Mapper.deleteBoard", board);
	}

	

}

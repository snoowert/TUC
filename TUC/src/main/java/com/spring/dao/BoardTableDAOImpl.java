package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.BoardTableVO;

public class BoardTableDAOImpl implements BoardTableDAO {
	SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<BoardTableVO> selectBoardTable() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("BoardTable-Mapper.selectBoardTable");
	}

	@Override
	public BoardTableVO selectBoardTableById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("BoardTable-Mapper.selectBoardTableById", id);
	}

	@Override
	public void insertBoardTable(BoardTableVO boardtable) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("BoardTable-Mapper.insertBoardTable", boardtable);
	}

	@Override
	public void updateBoardTable(BoardTableVO boardtable) throws SQLException {
		// TODO Auto-generated method stub
		session.update("BoardTable-Mapper.updateBoardTable", boardtable);
	}

	@Override
	public void deleteBoardTable(String category) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("BoardTable-Mapper.deleteBoardTable", category);
	}

}

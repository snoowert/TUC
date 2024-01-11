package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<BoardVO> selectRecipeList(PageMaker pagemaker) throws SQLException {
		// TODO Auto-generated method stub
		int offset = (pagemaker.getPage()-1)*pagemaker.getPerPageNum();
		int limmit = pagemaker.getPerPageNum();
		
		RowBounds rows = new RowBounds(offset,limmit);
		return session.selectList("Board-Mapper.selectRecipeList", pagemaker);
	}

	@Override
	public int selectRecipeListCount(PageMaker pagemaker) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("Board-Mapper.selectRecipeListCount");
	}

	@Override
	public int selectRecipeSeqNext() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("Board-Mapper.selectRecipeSeqNext");
	}

	@Override
	public BoardVO selectRecipeById(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("Board-Mapper.selectRecipeById", boardid);
	}

	@Override
	public void insertRecipe(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("Board-Mapper.insertRecipe", board);
	}

	@Override
	public void updateRecipe(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		session.update("Board-Mapper.updateRecipe", board);
	}

	@Override
	public void increaseViewCount(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		session.update("Board-Mapper.increaseViewCount", boardid);
	}

	@Override
	public void tempDeleteRecipe(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		session.update("Board-Mapper.tempDeleteRecipe", boardid);
	}

	@Override
	public void rewindRecipe(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		session.update("Board-Mapper.rewindRecipe", boardid);
	}

	@Override
	public void deleteRecipe(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("Board-Mapper.deleteRecipe", boardid);
	}

}

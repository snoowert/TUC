package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardVO;

public class BoardServiceImpl implements BoardService {
	BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> list() throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardList();
	}

	@Override
	public BoardVO select(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardById(board);
	}

	@Override
	public void insert(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(board);
	}

	@Override
	public void update(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(board);
	}

	@Override
	public void delete(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(board);
	}

}

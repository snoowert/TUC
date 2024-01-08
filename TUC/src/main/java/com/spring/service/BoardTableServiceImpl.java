package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.BoardTableDAO;
import com.spring.dto.BoardTableVO;

public class BoardTableServiceImpl implements BoardTableService{
	BoardTableDAO tableDAO;
	
	public void setBoardTableDAO(BoardTableDAO tableDAO) {
		this.tableDAO = tableDAO;
	}
	
	@Override
	public List<BoardTableVO> list() throws SQLException {
		// TODO Auto-generated method stub
		return tableDAO.selectBoardTable();
	}

	@Override
	public BoardTableVO select(String id) throws SQLException {
		// TODO Auto-generated method stub
		return tableDAO.selectBoardTableById(id);
	}

	@Override
	public void insert(BoardTableVO boardTable) throws SQLException {
		// TODO Auto-generated method stub
		tableDAO.insertBoardTable(boardTable);
	}

	@Override
	public void update(BoardTableVO boardTable) throws SQLException {
		// TODO Auto-generated method stub
		tableDAO.updateBoardTable(boardTable);
	}

	@Override
	public void delete(String Category) throws SQLException {
		// TODO Auto-generated method stub
		tableDAO.deleteBoardTable(Category);
	}

}

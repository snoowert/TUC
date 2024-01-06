package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.LikeTableDAO;
import com.spring.dto.LikeTableVO;

public class LikeTableServiceImpl implements LikeTableService{

	LikeTableDAO likeDAO;
	
	public void setLikeTableDAO(LikeTableDAO likeDAO) {
		this.likeDAO = likeDAO;
	}
	@Override
	public List<LikeTableVO> list() throws SQLException {
		// TODO Auto-generated method stub
		return likeDAO.selectLikeList();
	}

	@Override
	public LikeTableVO select(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		return likeDAO.selectLikeById(like);
	}

	@Override
	public List<LikeTableVO> listByBoard(String boardId) throws SQLException {
		// TODO Auto-generated method stub
		return likeDAO.selectLikeListByBoard(boardId);
	}

	@Override
	public void insert(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		likeDAO.insertLike(like);
	}

	@Override
	public void delete(LikeTableVO like) throws SQLException {
		// TODO Auto-generated method stub
		likeDAO.deleteLike(like);
	}
	
}

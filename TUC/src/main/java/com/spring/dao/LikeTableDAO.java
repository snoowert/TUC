package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.LikeTableVO;

public interface LikeTableDAO {
	List<LikeTableVO> selectLikeList() throws SQLException;

	LikeTableVO selectLikeById(LikeTableVO like) throws SQLException;

	int selectLikeListByBoard(String boardId) throws SQLException;

	void insertLike(LikeTableVO like) throws SQLException;

	void deleteLike(LikeTableVO like) throws SQLException;
}

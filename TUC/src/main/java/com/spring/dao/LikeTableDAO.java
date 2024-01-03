package com.spring.dao;

import java.util.List;

import com.spring.dto.LikeTableVO;

public interface LikeTableDAO {
	List<LikeTableVO> selectLikeList() throws Exception;

	LikeTableVO selectLikeById(LikeTableVO like) throws Exception;

	int selectLikeCount(int id) throws Exception;

	void insertLike(LikeTableVO like) throws Exception;

	void deleteLike(LikeTableVO like) throws Exception;
}

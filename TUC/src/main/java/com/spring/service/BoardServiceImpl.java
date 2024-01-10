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

	

}

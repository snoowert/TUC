package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.command.PageMaker;
import com.spring.dao.BoardDAO;
import com.spring.dao.CommentTableDAO;
import com.spring.dto.BoardVO;
import com.spring.dto.CommentTableVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	private CommentTableDAO commentDAO;
	
	public void setCommentTableDAO(CommentTableDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	@Override
	public List<BoardVO> list(PageMaker pagemaker) throws SQLException {
		List<BoardVO> list = boardDAO.selectRecipeList(pagemaker);
		if(list.size()>0) {
			for(BoardVO board : list) {
				int boardid = board.getBoardid();
				List<CommentTableVO> commentList = commentDAO.selectCommentByBoard(boardid);
				board.setCommentList(commentList);
			}
		}
		pagemaker.setTotalCount(boardDAO.selectRecipeListCount(pagemaker));
		return list;
	}

	@Override
	public void regist(BoardVO recipe) throws SQLException {
		// TODO Auto-generated method stub
		List<CommentTableVO> list = recipe.getCommentList();
		int boardid = boardDAO.selectRecipeSeqNext();
		
		recipe.setBoardid(boardid);
		boardDAO.insertRecipe(recipe);
		if(list!=null)
			for(CommentTableVO comment : list) {
				comment.setBoardid(boardid);
				comment.setUsername(recipe.getUsername());
				commentDAO.insertComment(comment);
			}
	}

	@Override
	public BoardVO read(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		BoardVO board = boardDAO.selectRecipeById(boardid);
		board.setCommentList(commentDAO.selectCommentByBoard(boardid));
		return board;
	}

	@Override
	public void modify(BoardVO recipe) throws SQLException {
		// TODO Auto-generated method stub
		List<CommentTableVO> list = recipe.getCommentList();
		int boardid = recipe.getBoardid();
		
		boardDAO.updateRecipe(recipe);
		if(list!=null)
			for(CommentTableVO comment:list) {
				comment.setBoardid(boardid);
				comment.setUsername(recipe.getUsername());
				commentDAO.insertComment(comment);
			}
	}

	@Override
	public void delete(int boardid) throws SQLException {
		// TODO Auto-generated method stub
		boardDAO.tempDeleteRecipe(boardid);
	}

	@Override
	public void registComment(CommentTableVO comment, int boardid) throws SQLException {
		// TODO Auto-generated method stub
		comment.setBoardid(boardid);
		commentDAO.insertComment(comment);
	}

	@Override
	public void modifyComment(CommentTableVO comment) throws SQLException {
		// TODO Auto-generated method stub
		commentDAO.updateComment(comment);
	}

	@Override
	public void deleteComment(String commentid) throws SQLException {
		// TODO Auto-generated method stub
		commentDAO.deleteComment(commentid);
	}

	

}

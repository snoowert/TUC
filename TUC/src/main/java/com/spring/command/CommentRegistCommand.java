package com.spring.command;

import com.spring.dto.CommentTableVO;

public class CommentRegistCommand {
	private String username;
	private int boardid;
	private String commentText;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public CommentTableVO toCommentVO() {
		CommentTableVO comment = new CommentTableVO();
		comment.setUsername(username);
		comment.setCommenttext(commentText);
		
		return comment;
	}
}

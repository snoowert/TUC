package com.spring.dto;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentTableVO {
	private String commentid;
	private String boardid;
	private String commenttext;
	private Date commentdate;
	private String username;
	private char isdelete;
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getBoardid() {
		return boardid;
	}
	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(char isdelete) {
		this.isdelete = isdelete;
	}
	
}

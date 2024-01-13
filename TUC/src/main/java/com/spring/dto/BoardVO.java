package com.spring.dto;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int boardid;
	private String category;
	private String thumnail;
	private String title;
	private String content;
	private Date boarddate;
	private Date updatedate;
	private int likecount;
	private int viewcount;
	private char isdelete;
	private String tableid;
	private String username;
	private String QAcontent;
	private char state;
	
	List<CommentTableVO> commentList;
	
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public char getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(char isdelete) {
		this.isdelete = isdelete;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQAcontent() {
		return QAcontent;
	}
	public void setQAcontent(String qAcontent) {
		QAcontent = qAcontent;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public List<CommentTableVO> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentTableVO> commentList) {
		this.commentList = commentList;
	}
	
}

package com.spring.command;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.BoardVO;

public class BoardRegistCommand {
	private String title;
	private String content;
	private String writer;
	private String category;
	private int boardid;
	private MultipartFile Picture;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public MultipartFile getPicture() {
		return Picture;
	}
	public void setPicture(MultipartFile picture) {
		Picture = picture;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setUsername(writer);
		board.setCategory(category);
		board.setBoardid(boardid);
		return board;
	}
	
	
}

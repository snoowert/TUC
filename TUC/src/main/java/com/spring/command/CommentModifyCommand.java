package com.spring.command;

import com.spring.dto.CommentTableVO;

public class CommentModifyCommand {
	String writer;
	String content;
	String commentid;

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public CommentTableVO toCommentVO() {
		CommentTableVO comment = new CommentTableVO();
		comment.setCommentid(commentid);
		comment.setCommenttext(content);
		comment.setUsername(writer);
		return comment;
	}
}

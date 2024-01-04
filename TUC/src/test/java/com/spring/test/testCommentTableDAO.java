package com.spring.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CommentTableDAO;
import com.spring.dto.CommentTableVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@Transactional
public class testCommentTableDAO {
	@Autowired
	private CommentTableDAO commentdao;
	
	@Test
	public void testSelectCommentList() throws Exception{
		List<CommentTableVO> CommentList = commentdao.selectCommentList();

		Assert.assertEquals(1, CommentList.size());
	}
	
	@Test
	public void testSelectCommentById() throws Exception{
		String testUsername="aa";
		CommentTableVO targetComment = commentdao.selectCommentById(testUsername);
		Assert.assertEquals(testUsername, targetComment.getUsername());
	}
	
	String insertId = "bb";
	@Test
	@Rollback
	public void testInsertComment() throws Exception{
		CommentTableVO targetVO = new CommentTableVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		java.util.Date setDate = format.parse("2024.01.04");
		targetVO.setCommentid("c02");
		targetVO.setBoardid("b01");
		targetVO.setCommenttext("dump text");
		targetVO.setCommentdate(setDate);
		targetVO.setUsername(insertId);
		targetVO.setIsdelete('N');
		commentdao.insertComment(targetVO);
		
		CommentTableVO getComment = commentdao.selectCommentById(targetVO.getUsername());

		Assert.assertEquals(targetVO.getUsername(), getComment.getUsername());
		
	}
}

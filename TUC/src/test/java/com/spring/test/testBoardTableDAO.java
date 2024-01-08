package com.spring.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BoardTableDAO;
import com.spring.dto.BoardTableVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@Transactional
public class testBoardTableDAO {
	@Autowired
	BoardTableDAO tableDAO;
	
	@Test
	public void testSelectBoardTable() throws Exception{
		List<BoardTableVO> BoardTableList = tableDAO.selectBoardTable();
		
		Assert.assertEquals(2, BoardTableList.size());
	}
	
	@Test
	public void testSelectBoardTableById() throws Exception{
		BoardTableVO table = tableDAO.selectBoardTableById("t01");
		
		Assert.assertEquals("t01", table.getTablenum());
	}
	
	String insertTableNum = "t02";
	@Test
	@Rollback
	public void testInsertBoardTable() throws Exception{
		BoardTableVO table = new BoardTableVO();
		table.setTablenum(insertTableNum);
		table.setCategory("test");
		table.setIsuse('Y');
		
		tableDAO.insertBoardTable(table);
		
		BoardTableVO boardTable = tableDAO.selectBoardTableById(insertTableNum);
		
		Assert.assertEquals(insertTableNum, boardTable.getTablenum());
	}
	
	@Test
	@Rollback
	public void testUpdateBoardTable() throws Exception{
		String testCategory = "ccc";
		BoardTableVO table = tableDAO.selectBoardTableById("t01");
		table.setCategory(testCategory);
		
		tableDAO.updateBoardTable(table);
		
		table = tableDAO.selectBoardTableById("t01");
		
		Assert.assertEquals(testCategory, table.getCategory());
	}
	
	@Test
	@Rollback
	public void testDeleteBoardTable() throws Exception{
		testInsertBoardTable();
		
		List<BoardTableVO> tableList = tableDAO.selectBoardTable();
		Assert.assertEquals(3, tableList.size());
		
		tableDAO.deleteBoardTable("test");
		tableList = tableDAO.selectBoardTable();
		Assert.assertEquals(2, tableList.size());
	}
}

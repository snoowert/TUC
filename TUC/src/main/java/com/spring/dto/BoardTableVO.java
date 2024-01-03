package com.spring.dto;

public class BoardTableVO {
	private String tablenum;
	private String category;
	private char isuse;
	public String getTablenum() {
		return tablenum;
	}
	public void setTablenum(String tablenum) {
		this.tablenum = tablenum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getIsuse() {
		return isuse;
	}
	public void setIsuse(char isuse) {
		this.isuse = isuse;
	}
	
}

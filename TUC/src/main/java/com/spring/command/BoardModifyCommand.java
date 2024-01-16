package com.spring.command;

public class BoardModifyCommand extends BoardRegistCommand{
	private String oldPicture;
	
	public String getOldPicture() {
		return oldPicture;
	}
	public void setOldPicture(String oldPicture) {
		this.oldPicture = oldPicture;
	}
}


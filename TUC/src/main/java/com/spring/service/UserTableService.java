package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.UserTableVO;

public interface UserTableService {
	List<UserTableVO> list() throws SQLException;
	
	UserTableVO select(String id) throws SQLException;
	
	void insert(UserTableVO user) throws SQLException;
	
	void update(UserTableVO user) throws SQLException;
	
	void delete(UserTableVO user) throws SQLException;
}

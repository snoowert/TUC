package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.UserTableVO;

public interface UserTableDAO {
	List<UserTableVO> selectUserList() throws SQLException;

	UserTableVO selectUserById(String id) throws SQLException;

	void insertUser(UserTableVO user) throws SQLException;

	void updateUser(UserTableVO user) throws SQLException;

	void deleteUser(UserTableVO user) throws SQLException;
}

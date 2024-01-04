package com.spring.dao;

import java.util.List;

import com.spring.dto.UserTableVO;

public interface UserTableDAO {
	List<UserTableVO> selectUserList() throws Exception;

	UserTableVO selectUserById(String id) throws Exception;

	void insertUser(UserTableVO user) throws Exception;

	void updateUser(UserTableVO user) throws Exception;

	void deleteUser(UserTableVO user) throws Exception;
}

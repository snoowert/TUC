package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.UserTableDAO;
import com.spring.dto.UserTableVO;

public class UserTableServiceImpl implements UserTableService {
	UserTableDAO userDAO;
	public void setUserTableDAO(UserTableDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public List<UserTableVO> list() throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.selectUserList();
	}

	@Override
	public UserTableVO select(String id) throws SQLException {
		// TODO Auto-generated method stub
		return userDAO.selectUserById(id);
	}

	@Override
	public void insert(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		userDAO.insertUser(user);
	}

	@Override
	public void update(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);
	}

	@Override
	public void delete(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		userDAO.deleteUser(user);
	}

}

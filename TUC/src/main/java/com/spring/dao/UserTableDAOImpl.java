package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.UserTableVO;

public class UserTableDAOImpl implements UserTableDAO {
	SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<UserTableVO> selectUserList() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList("UserTable-Mapper.selectUserList");
	}

	@Override
	public UserTableVO selectUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne("UserTable-Mapper.selectUserById", id);
	}

	@Override
	public void insertUser(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		session.insert("UserTable-Mapper.insertUser", user);
	}

	@Override
	public void updateUser(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		session.update("UserTable-Mapper.updateUser", user);
	}

	@Override
	public void deleteUser(UserTableVO user) throws SQLException {
		// TODO Auto-generated method stub
		session.delete("UserTable-Mapper.deleteUser", user);
	}

}

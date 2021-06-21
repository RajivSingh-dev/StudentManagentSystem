package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.login.controller.DBConnection;
import com.login.model.User;

public class RegisterDAOImp implements RegisterDAO{
	
	final String CREATE = "INSERT INTO logins (userName, password, email) VALUES (?,?,?)";
	
	private DBConnection connection = DBConnection.getInstance();
	
	public void create(User user) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(CREATE);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			if(preparedStatement.executeUpdate() == 0 ){
	                System.out.println("Something went wrong");
	        }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer k) {
		// TODO Auto-generated method stub
		
	}

}

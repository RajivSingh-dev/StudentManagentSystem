package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.controller.DBConnection;

public class LoginDAO {

	final String GET_ONE = "SELECT * FROM logins WHERE userName=? AND password=?";
	
	private DBConnection connection = DBConnection.getInstance();
	
	public boolean authentication(String userName, String password) {		
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.getConnection().prepareStatement(GET_ONE);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   /// i know is bad practice its just for now
		}finally {
			connection.closeConnection();
		}
		
		
		return false;
	}
}

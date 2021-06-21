package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.controller.DBConnection;
import com.login.model.Student;

public class StudentDAOImp implements StudentDAO {
	
	final String CREATE = "INSERT INTO Student (studentName, address) VALUES (?,?)";
	final String DELETE = "DELETE FROM Student WHERE id = ?";
	final String UPDATE = "UPDATE Student SET studentName = ?, address = ? WHERE id = ?";
	final String GET_ALL = "SELECT id, studentName, address FROM Student ";
	final String FIND_ONE = "SELECT * FROM Student WHERE id = ?";
	
	private DBConnection connection = DBConnection.getInstance();
	
	public void create(Student student) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(CREATE);
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getAddress());
			if(preparedStatement.executeUpdate() == 0 ){
                System.out.println("Something went wrong");
            }
		} catch (SQLException e) {
			System.out.println("Create student error");  /// need to implement daoexception
		}finally {
			connection.closeConnection();
		}
	}
	
	public List<Student> findAll(){
		PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Student> studentList = new ArrayList();
        
        try {
			preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				studentList.add(new Student(resultSet.getInt("id"),resultSet.getString("studentName"), resultSet.getString("address")));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
        return studentList;
	}
	
	public Student findOne(Integer id){
		PreparedStatement preparedStatement;
        ResultSet resultSet;
        Student student = null;
        
        try {
			preparedStatement = connection.getConnection().prepareStatement(FIND_ONE);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) {
				student = new Student(resultSet.getInt("id"), resultSet.getString("studentName"),resultSet.getString("address"));
			}else {
				System.out.println("Student not found");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.closeConnection();
		}
		return student;
	}
	
	// I have to see why the initial query is not working like the others
	public void update(Student student) {
		PreparedStatement preparedStatement;	
		try {
			String sql = "UPDATE Student SET studentName = '"+ student.getStudentName()+"', "
					+ "address = '"+ student.getAddress()+"' where id="+ student.getId(); // this query works just fine
			preparedStatement = connection.getConnection().prepareStatement(sql);					
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
		
	}
	
	public void delete(Integer id) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
	}

	

	

}

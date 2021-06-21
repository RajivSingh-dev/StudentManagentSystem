package com.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.StudentDAOImp;
import com.login.model.Student;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private StudentDAOImp studentDAOImp = new StudentDAOImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
		
        if(action == null) {
        	action = "LIST";
        }
        
        switch(action) {
        
        	case "LIST":
        		listStudents(request, response);
        	break;
        	
        	case "EDIT":
        		editStudent(request, response);
        	break;
        	
        	case "DELETE":
        		deleteStudent(request, response);
        	break;
        }
        
	}
	

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		studentDAOImp.delete(Integer.parseInt(id));
		listStudents(request,response);
	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Student student = studentDAOImp.findOne(Integer.parseInt(id));
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);			
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = studentDAOImp.findAll();
		request.setAttribute("studentList", studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		StudentDAOImp bookDAO = new StudentDAOImp();
		
		String id = request.getParameter("id");
		String bookName = request.getParameter("sname");
		String authorName = request.getParameter("address");
	
		if(!(id == null)) {			
			Student student = new Student(Integer.parseInt(id), bookName, authorName);
			bookDAO.update(student);
			response.sendRedirect("welcome.jsp");
		}else {			
			Student student = new Student(bookName, authorName);
			bookDAO.create(student);
			response.sendRedirect("welcome.jsp");
		}
	}

}

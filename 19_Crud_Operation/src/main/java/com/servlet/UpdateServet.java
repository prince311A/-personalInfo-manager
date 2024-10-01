package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		PrintWriter k = response.getWriter();
		response.setContentType("text/html");
	
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
		if(name.trim().isEmpty() || email.trim().isEmpty() || dob.trim().isEmpty() || address.trim().isEmpty() || qualification.trim().isEmpty()) {
			k.print("<h3 style = 'color:red'>Please Fill All The Entities </h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/edit_student.jsp");
			rd.include(request, response);
			
		}else {
		
		  Student s1 = new Student(id,name,dob,address,qualification,email);
		 
		  StudentDao dao = new StudentDao(DBConnect.getConn());
		  
		  HttpSession session = request.getSession();
		  
		 boolean f = dao.editStudent(s1);
		 if(f) {
//			 session.setAttribute("succsmsg", "Student Data Inserted Sucessfully...");// not working because jstl jar not added to this project
//			 response.sendRedirect("index.jsp");// not working because jstl jar not added to this project
			 k.print("<h3 style = 'color:green'>Student Data Updated Sucessfully</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
//			System.out.println("Data inserted sucessfully"); 
		 }
		 else {
//			 session.setAttribute("failmsg", "Something Went Wrong");// not working because jstl jar not added to this project
//			 response.sendRedirect("index.jsp");// not working because jstl jar not added to this project
			 k.print("<h3 style = 'color:green'>Something Went Wrong</h3>");
			 RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			 rd.include(request, response);
//			 System.out.println("Something Went Wrong");
			
		}
	}

}
}

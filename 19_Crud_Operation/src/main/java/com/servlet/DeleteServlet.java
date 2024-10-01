package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.conn.DBConnect;
import com.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter k = resp.getWriter();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao(DBConnect.getConn());
		boolean f = dao.deleteStudent(id);
		HttpSession session = req.getSession();
		 if(f) {
//			 session.setAttribute("succsmsg", "Student Data Deleted Sucessfully...");// not working because jstl jar not added to this project
//			 resp.sendRedirect("index.jsp");// not working because jstl jar not added to this project
			 k.print("<h3 style = 'color:green'>Student Data Deleted Sucessfully</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
//			System.out.println("Data inserted sucessfully"); 
		 }
		 else {
//			 session.setAttribute("failmsg", "Something Went Wrong");// not working because jstl jar not added to this project
//			 resp.sendRedirect("index.jsp");// not working because jstl jar not added to this project
			 k.print("<h3 style = 'color:green'>Something Went Wrong</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
//			 System.out.println("Something Went Wrong");
       
		       
		}
	}

}

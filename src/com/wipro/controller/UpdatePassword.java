package com.wipro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bean.UserBean;
import com.wipro.dao.UserDAO;


@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		
		UserBean userbean=new UserBean();
		
		userbean.setUserName(name);
		userbean.setPassword(password);

		
		
		String status1= UserDAO.checkUser(userbean);
		if(status1 != "Success") {
			out.print("<p>user does not exist!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			int status=UserDAO.update(userbean);
			if(status>0){
				out.print("<p>Password updated successfully!</p>");
				request.getRequestDispatcher("index.html").include(request, response);
			}else{
				out.println("Sorry! unable to update password");
			}
		}
		
		out.close();
		
		
	}

}

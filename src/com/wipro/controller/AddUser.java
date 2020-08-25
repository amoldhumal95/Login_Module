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


@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		
		UserBean userbean=new UserBean();
		userbean.setUserName(name);
		userbean.setPassword(password);
		
		String status1 = UserDAO.checkOnlyUser(userbean);
		if(status1 == "Success") {
			out.print("<p>User already exists</p>");
			request.getRequestDispatcher("newUser.html").include(request, response);
		}
		else {
			int status=UserDAO.add(userbean);
			 if(status>0){
					out.print("<p>Record saved successfully!</p>");
					request.getRequestDispatcher("index.html").include(request, response);
				}else{
					out.println("Sorry! unable to save record");
				}
		}
		
		out.close();
		
		
	}

}

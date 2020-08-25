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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		UserBean userBean = new UserBean();
		userBean.setUserName(userName);
		userBean.setPassword(password);
		
		String status = UserDAO.checkUser(userBean);
		if(status.equals("Success"))
		{
		out.print("<script>var win=window.open();win.document.write('Redirecting to Homepage...');setTimeout(function(){win.close()},250);</script>");
		request.getRequestDispatcher("Home.html").include(request, response);
		}
		else{
		out.print("<script>alert('Invalid Username or Password!');</script>");
		request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}

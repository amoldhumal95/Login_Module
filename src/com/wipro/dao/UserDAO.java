package com.wipro.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.wipro.bean.UserBean;
import com.wipro.util.DBUtil;

public class UserDAO {
	
	
/******************************login*******************************/
public static String checkUser(UserBean userBean){
String status = "Fail";
try{
String sql = "select * from user_table where username=? and password=?";
Connection con = DBUtil.getConnection();
PreparedStatement st = con.prepareStatement(sql);
st.setString(1, userBean.getUserName());
st.setString(2, userBean.getPassword());
ResultSet rs = st.executeQuery();
if(rs.next())
status = "Success";
st.close();
con.close();
}
catch(Exception e){e.printStackTrace();}
return status;
}
/********************************Check user existance****************/
public static String checkOnlyUser(UserBean userBean){
String status = "Fail";
try{
String sql = "select * from user_table where username=?";
Connection con = DBUtil.getConnection();
PreparedStatement st = con.prepareStatement(sql);
st.setString(1, userBean.getUserName());
ResultSet rs = st.executeQuery();
if(rs.next())
status = "Success";
st.close();
con.close();
}
catch(Exception e){e.printStackTrace();}
return status;
}

/********************************Add User****************************/
public static int add(UserBean userbean){
	int status=0;
	try{
		Connection con=DBUtil.getConnection();
		
		PreparedStatement ps=con.prepareStatement("insert into user_table(username,password) values (?,?)");
		
		ps.setString(1,userbean.getUserName());
		ps.setString(2,userbean.getPassword());
		
		status=ps.executeUpdate();
		
		con.close();
	}catch(Exception ex){ex.printStackTrace();}
	
	return status;
}

/**********************************Change Password************************/
public static int update(UserBean userbean){
	int status=0;
	try{
		Connection con=DBUtil.getConnection();
		
		PreparedStatement ps=con.prepareStatement("update user_table set password=? where username=?");
		ps.setString(1,userbean.getPassword());
		ps.setString(2,userbean.getUserName());

		
		status=ps.executeUpdate();
		
		con.close();
	}catch(Exception ex){ex.printStackTrace();}
	
	return status;
}



}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.manager.User"%>
<%@ page import="db.manager.UserManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>

<%
	String id="", name ="", email="", sex="", tel="", memo="";
String sellingprice="";
if(request.getParameter("userid")!=null)
	id = request.getParameter("userid").toString();
if(request.getParameter("username")!=null)
	name = request.getParameter("username").toString();
if(request.getParameter("email")!=null)
	email = request.getParameter("email").toString();
if(request.getParameter("sex")!=null)
	sex = request.getParameter("sex").toString();
if(request.getParameter("tel")!=null)
	tel = request.getParameter("tel").toString();
if(request.getParameter("memo")!=null)
	memo = request.getParameter("memo").toString();

session.setAttribute("lstUser", null);
String strMethod="";
if(request.getParameter("method")!=null)
	strMethod = request.getParameter("method").toString();

if(strMethod.equals("del"))
{
	User user = UserManager.getUserById(conn, id);	
	user.setEnable(false);
	UserManager.save(conn, user);
}else{
	if(strMethod.equals("edit") && !name.equals(""))
	{
		User user = UserManager.getUserById(conn, id);
		user.setName(name);
		user.setEmail(email);
		user.setTel(tel);
		user.setSex(sex);
		user.setMemo(memo);
		//System.out.println(user.toString());
		if(UserManager.save(conn, user))
		{
	session.setAttribute("Message","使用者儲存成功!");
	session.setAttribute("lstUser", null);
		}
	}
}

response.sendRedirect("UserManage.jsp");
%>
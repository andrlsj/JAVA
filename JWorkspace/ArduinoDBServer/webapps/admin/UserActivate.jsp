<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.manager.UserManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "db.manager.User"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%
String strId="";
boolean bCheck = false;

if(request.getParameter("id")!=null && request.getParameter("checked")!=null)
{
	strId = request.getParameter("id").toString();
	bCheck = Boolean.parseBoolean(request.getParameter("checked").toString());
	User usr = UserManager.getUserById(sqliteConn, strId);	
	usr.setEnable(bCheck);
	UserManager.Save(usr);
	session.setAttribute("lstUser", null);
	session.setAttribute("Message", "設定成功!");
	response.sendRedirect("UserManage.jsp");
}
%>
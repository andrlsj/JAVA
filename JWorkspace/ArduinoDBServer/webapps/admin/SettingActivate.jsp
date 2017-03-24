<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "db.manager.Setting"%>
<%@ page import="db.manager.SettingManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%
String strId="";
boolean bCheck = false;

if(request.getParameter("id")!=null && request.getParameter("checked")!=null)
{
	strId = request.getParameter("id").toString();
	bCheck = Boolean.parseBoolean(request.getParameter("checked").toString());
	Setting setting = SettingManager.getSettingById(sqliteConn, strId);	
	setting.setEnable(bCheck);
	SettingManager.Save(setting);
	session.setAttribute("lstSetting", null);
	session.setAttribute("Message", "設定成功!");
	response.sendRedirect("SystemParameterView.jsp");
}
%>
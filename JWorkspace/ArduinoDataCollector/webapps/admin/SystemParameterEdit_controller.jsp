<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.manager.Setting"%>
<%@ page import="db.manager.SettingManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>

<%
String id="", sysname="", name ="", value="", memo="",strEnable="";

if(request.getParameter("id")!=null)
	id = request.getParameter("id").toString();
if(request.getParameter("sysname")!=null)
	sysname = request.getParameter("sysname").toString();
if(request.getParameter("name")!=null)
	name = request.getParameter("name").toString();
if(request.getParameter("value")!=null)
	value = request.getParameter("value").toString();
if(request.getParameter("memo")!=null)
	memo = request.getParameter("memo").toString();
if(request.getParameter("enable")!=null)
	strEnable = request.getParameter("enable").toString();

session.setAttribute("lstSetting", null);
System.out.println(id + " " + name + " " + strEnable + " " + memo);

Setting setting = SettingManager.getSettingById(conn, id);	
setting.setSysname(sysname);
setting.setName(name);
setting.setMemo(memo);
setting.setValue(value);
setting.setEnable(strEnable.equalsIgnoreCase("on"));
if(SettingManager.save(conn, setting))
{
	session.setAttribute("Message","設定儲存成功!!");
	session.setAttribute("lstProduct", null);
}
response.sendRedirect("SystemParameterView.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Util.SystemUtil" %>
<%@ page import="OracleDB.manager.SNC01Manager" %>
<%@ include file="common/conn.jsp"%>
<%!
public static String getDeviceId(HttpServletRequest request) 
{  
    String id = request.getParameter("device");  
 
    return id;  
} %>
<%
System.out.println(SystemUtil.getIp(request) + getDeviceId(request));
String strDeviceID = getDeviceId(request);
String strIP = SystemUtil.getIp(request);
SNC01Manager.updateIPByDeviceId(strDeviceID, strIP);
%>
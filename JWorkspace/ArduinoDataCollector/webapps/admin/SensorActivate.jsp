<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="snc01ManagerWebService.Snc01"%>
<%@ page import="snc01ManagerWebService.SNC01Manager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%
String strId="";
String strCheck = "0";

if(request.getParameter("machineid")!=null && request.getParameter("checked")!=null)
{
	String strURL = hmConfig.get("ArduinoDBServerIP");
	if(strURL.equals(""))
		strURL = "192.168.4.161";
	String strWsdlPath = "http://" + strURL + ":9092/SNC01Manager?wsdl";
	strId = request.getParameter("machineid").toString();
	strCheck = request.getParameter("checked").toString();
	if(strCheck.equals("false"))
		strCheck="0";
	if(strCheck.equals("true"))
		strCheck="1";
	System.out.println(strId + " " + strCheck);
	SNC01Manager m = new SNC01Manager();
	Snc01 snc01 = m.getSNCX01ByMachineName(strWsdlPath, strId);	
	snc01.setEnable(strCheck);
	System.out.println(snc01.getMemo());
	m.Save(strWsdlPath, snc01);
	session.setAttribute("Message", "設定成功!");
	response.sendRedirect("SensorView.jsp");
}
%>
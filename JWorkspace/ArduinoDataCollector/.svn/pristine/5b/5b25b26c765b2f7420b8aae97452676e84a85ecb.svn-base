<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="snc01ManagerWebService.Snc01"%>
<%@ page import="snc01ManagerWebService.SNC01Manager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%
String strId="";
String strEnable = "0";

	String strURL = hmConfig.get("ArduinoDBServerIP");
	if(strURL.equals(""))
		strURL = "192.168.4.161";
	String strWsdlPath = "http://" + strURL + ":9092/SNC01Manager?wsdl";
	strId = request.getParameter("machinename").toString();
	if(strId.equals(""))
		strId = request.getParameter("machineid").toString();
	String strMemo = request.getParameter("sensormemo").toString();
	String strMins = request.getParameter("mins").toString();
// 	String strCompanyId = request.getParameter("site").toString();
// 	String strIP = request.getParameter("ip").toString();
//	System.out.println(strId + " " + strEnable+ " " + strMemo + " " +strIP + " " + strCompanyId);
	SNC01Manager m = new SNC01Manager();
	
	Snc01 snc01 = new Snc01();
	if(request.getParameter("machinename")!=null)
	{
		snc01 = m.getSNCX01ByMachineName(strWsdlPath, strId);	
	}
// 	snc01.setCompanyId(strCompanyId);
	snc01.setMachineName(strId);
// 	snc01.setIp(strIP);
	snc01.setMemo(strMemo);
	snc01.setMins(strMins);
	m.Save(strWsdlPath, snc01);
	session.setAttribute("Message", "設定成功!");
	response.sendRedirect("SensorView.jsp");

%>
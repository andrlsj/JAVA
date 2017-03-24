<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cymmetrik.webservices.hr.Employee"%>
<%@ page import="com.cymmetrik.webservices.hr.HRManager"%>
<%@ page import = "db.manager.User"%>
<%@ page import = "db.manager.UserManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%
String strId="";
if(request.getParameter("id")!=null)
{
	strId = request.getParameter("id").toString();	
	String strWSDL = "http://" + hmConfig.get("HRWebServiceServerIP") + ":9000/HRManager?wsdl";
	//String strWSDL = "http://192.168.116.11:9000/HRManager?wsdl";
	//System.out.println(strWSDL);
	List<Employee> lstEmp = HRManager.getEmployeeByEmpNo(strWSDL, strId);
	Employee emp = lstEmp.get(0);
	User user = new User();
	List<User> lstUser = UserManager.getUserByLikeName(emp.getEmpName());
	if(lstUser.size()>0)
	{
		user = lstUser.get(0);
		session.setAttribute("Message", "使用者 "+ user.getName() + " 已存在!");
	}else{
		user.setId(emp.getEmpNo());
		user.setEmail(emp.getEmail());
		user.setName(emp.getEmpName());
		user.setTel("");
		user.setSex(emp.getSex());
		UserManager.Save(user);	
		session.setAttribute("lstUser", null);
		session.setAttribute("Message", "員工成功轉成使用者!");
	}
	response.sendRedirect("EmployeeManage.jsp");
}
%>
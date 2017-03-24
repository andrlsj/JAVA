<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.cymmetrik.webservices.hr.Employee"%>
<%@ page import="com.cymmetrik.webservices.hr.HRManager"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<% 
String strSearch="";
if(request.getParameter("txtSearchEmployee")==null)
{
	if(strSearch.equals("") && session.getAttribute("txtSearchEmployee")!=null)
		strSearch = session.getAttribute("txtSearchEmployee").toString();
}else{
	strSearch=request.getParameter("txtSearchEmployee").toString();
}

int iPage=1, iStart=0, iEnd=0, iTotalPages=1;
if(request.getParameter("page")!=null)
{
	iPage = Integer.parseInt(request.getParameter("page").toString());	
}

List<Employee> lstEmployee = new ArrayList<Employee>();
if(lstEmployee.size() == 0 && !strSearch.equals(""))
{
	String strWSDL = "http://" + hmConfig.get("HRWebServiceServerIP") + ":9000/HRManager?wsdl";
	//String strWSDL = "http://192.168.116.11:9000/HRManager?wsdl";
	//System.out.println(strWSDL);
	lstEmployee = HRManager.getEmployeeByLikeNameLoginId(strWSDL, strSearch);
	session.setAttribute("lstEmployee", lstEmployee);
}
session.setAttribute("txtSearchEmployee", strSearch);
iTotalPages = (int)Math.ceil(((double)lstEmployee.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstEmployee.size())
	iEnd = lstEmployee.size();
%>
<table align="center">
  <tr>
    <td>姓名<input type="text" id="txtSearchEmployee" value="<%=strSearch%>"></td>
    <td><input type="button" value="搜尋" onclick="search()"></td>
    <td>    	
    	(<%=iPage%>/<%=iTotalPages%>)  
    	<a href="EmployeeManage.jsp?txtSearch=<%=strSearch%>&page=1">最前頁</a>
    	<% if(iPage !=1){ %>
    	<a href="EmployeeManage.jsp?txtSearch=<%=strSearch%>&page=<%=iPage-1%>">上一頁</a>
    	<%} %>
    	<% if(iPage !=iTotalPages){ %>
    	<a href="EmployeeManage.jsp?txtSearch=<%=strSearch%>&page=<%=iPage+1%>">下一頁</a>
    	<%} %>
    	<a href="EmployeeManage.jsp?txtSearch=<%=strSearch%>&page=<%=iTotalPages%>">最後頁</a>    	
    </td>
  </tr>
</table>
<br>
<%
System.out.println(lstEmployee.size());
if(lstEmployee.size()>0)
{
%>	
<table align="center" border="1px">
  <tr>
  	<th>公司</th>
    <th>工號</th>
    <th>姓名</th>
    <th>部門</th>
    <th>性別</th>    
    <th>操作</th>
  </tr>
<% 		for(int i=iStart;i<iEnd;i++) 
  		{
	  		Employee emp = lstEmployee.get(i);
%>
    <tr>
    	<td><%=emp.getCompId()%>
    	<td><%=emp.getEmpNo()%></td>
    	<td><%=emp.getEmpName()%></td>
    	<td><%=emp.getDeptName()%></td>
    	<td><%=emp.getSex() %></td>
    	<td>
    		<input type="button" onclick="Transfer2User('<%=emp.getEmpNo()%>');" value="轉成使用者">
<%--     		<input type="button" onclick="Transfer2Customer('<%=emp.getId()%>');" value="轉成 EC客戶"> --%>
    	</td>
    	    	
    </tr>
<%
  		}
  %>
</table>
<%
}
%>
<script>
function search()
{
	var obj=document.getElementById("txtSearchEmployee");
	window.location.href="EmployeeManage.jsp?txtSearchEmployee=" + obj.value;
}
function Transfer2User(id)
{
	if(id !='' && confirm("確定轉成使用者?"))
	{
		window.location.href="Transfer2User.jsp?id=" + id;	
	}	
}
function Transfer2Customer(id)
{
	if(id !='' && confirm("確定轉成客戶?"))
	{
		window.location.href="Transfer2Customer.jsp?id=" + id;	
	}	
}
</script>
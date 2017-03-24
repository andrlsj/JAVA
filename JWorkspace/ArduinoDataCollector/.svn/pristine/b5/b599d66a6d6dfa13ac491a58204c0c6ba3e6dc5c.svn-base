<%@page import="data.GetData.GetData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="snc02ManagerWebService.Snc02"%>
<%@ page import="snc02ManagerWebService.SNC02Manager"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<%

int iPage=1, iStart=0, iEnd=0, iTotalPages=1;
if(request.getParameter("page")!=null)
{
	iPage = Integer.parseInt(request.getParameter("page").toString());	
}
HashMap<String,String> hmSite = GetData.getSite("./config/config.ini", "Site");
List<Snc02> lstSnc02 = new ArrayList<Snc02>();

String strURL = hmConfig.get("ArduinoDBServerIP");
if(strURL.equals(""))
	strURL = "192.168.4.161";
String strWsdlPath = "http://" + strURL + ":9092/SNC02Manager?wsdl";
//System.out.println(strWsdlPath + " " + hmSite.get("site"));
lstSnc02 = SNC02Manager.getRecentSNCX02S(strWsdlPath, hmSite.get("site")); 	
System.out.println(lstSnc02.size());
iTotalPages = (int)Math.ceil(((double)lstSnc02.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstSnc02.size())
	iEnd = lstSnc02.size();
%>
<table align="center">
  <tr>
    <td>    	
    	(<%=iPage%>/<%=iTotalPages%>)  
    	<a href="SensorDataView.jsp?page=1">最前頁</a>
    	<%
    		if(iPage !=1){
    	%>
    	<a href="SensorDataView.jsp?page=<%=iPage-1%>">上一頁</a>
    	<%
    		}
    	%>
    	<%
    		if(iPage !=iTotalPages){
    	%>
    	<a href="SensorDataView.jsp?page=<%=iPage+1%>">下一頁</a>
    	<%
    		}
    	%>
    	<a href="SensorDataView.jsp?page=<%=iTotalPages%>">最後頁</a>    	
    </td>
  </tr>
</table>
<br>
<%
if(lstSnc02.size()>0)
{
%>	
<table align="center" border="1px">
  <tr>
    <th>設備名稱</th>
    <th>感測器種類</th>
    <th>值</th>
    <th>時間</th>
  </tr>
<%
	for(int i=iStart;i<iEnd;i++) 
  		{
		Snc02 snc02 = lstSnc02.get(i);
%>
    <tr>
		<td><%=snc02.getSncx0201()%></td>
    	<td><%=snc02.getSncx0202()%></td>  
    	<td><%=snc02.getSncx0203()%></td>
		<td><%=snc02.getSncx0204()%></td>
    </tr>
<%
  		}
  %>
</table>
<%
}
%>
<script>


</script>
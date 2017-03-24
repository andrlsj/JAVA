<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="snc02ManagerWebService.Snc02"%>
<%@ page import="snc02ManagerWebService.SNC02Manager"%>
<%@ page import="db.manager.SensorData"%>
<%@ page import="db.manager.SensorDataManager"%><%@ page import="db.manager.SensorData"%>
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

List<SensorData> lstSensorData = new ArrayList<SensorData>();
lstSensorData = SensorDataManager.getSensorDataNotTransferred(conn); 	
System.out.println(lstSensorData.size());
iTotalPages = (int)Math.ceil(((double)lstSensorData.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstSensorData.size())
	iEnd = lstSensorData.size();
%>
<%if(lstSensorData.size()>0){ %>
<table align="center">
	<tr>
		<td><input type="button" value="轉入" onclick="transfer()"></td>
	</tr>
</table>
<%} %>
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
if(lstSensorData.size()>0)
{
%>	
<table align="center" border="1px">
  <tr>
  	<th>ID</th>
    <th>設備名稱</th>
    <th>感測器種類</th>
    <th>值</th>
    <th>時間</th>
  </tr>
<%
	for(int i=iStart;i<iEnd;i++) 
  	{
		SensorData sd = lstSensorData.get(i);
%>
    <tr>
		<td><%=sd.getId()%></td>
    	<td><%=sd.getMachineId()%></td>  
    	<td><%=sd.getSensorType()%></td>
		<td><%=sd.getValue()%></td>
		<td><%=sd.getSystemDT()%></td>
    </tr>
<%
  	}
  %>
</table>
<%
}
%>
<script>
function transfer()
{
	window.location.href ="reSendData.jsp";
}

</script>
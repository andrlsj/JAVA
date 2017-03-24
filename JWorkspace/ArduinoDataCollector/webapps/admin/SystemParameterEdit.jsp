<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.manager.Setting"%>
<%@ page import="db.manager.SettingManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<%
String strId="";
if(request.getParameter("id")==null)
{
	response.sendRedirect("SystemParameterView.jsp");
}

strId = request.getParameter("id");
Setting setting = SettingManager.getSettingById(conn, strId);
String strChk="";
if(setting.isEnable()) 
	strChk = "checked";

%>
<br>
<form id="form1" action="SystemParameterEdit_controller.jsp">
<div id="UserEdit" style="display:block">
	<table align="center" border="0px">
		<tr>
			<td>編號</td>
			<td>
				<input type="hidden" id="method" name="method" value="edit">
				<input type="text" id="settingid" name="settingid" value="<%=strId%>" disabled>
				<input type="hidden" id="id" name="id" value="<%=strId%>">
			</td>
		</tr>
		<tr>
			<td>系統</td>
			<td>
				<input type="text" id="sysname" name="sysname" value="<%=setting.getSysname()%>" size="40">
			</td>
		</tr>		
		<tr>
			<td>鍵名(key)</td>
			<td>
				<input type="text" id="name" name="name" value="<%=setting.getName()%>" size="40">
			</td>
		</tr>
		<tr>
			<td>值</td>
			<td>
				<input type="text" id="value" name="value" value="<%=setting.getValue()%>" size="40">
			</td>
		</tr>	
		<tr>
			<td>啟用</td>
			<td>
				<input type="checkbox" id="enable" name="enable" <%=strChk%>>
			</td>
		</tr>			
		<tr>
			<td>備註</td>
			<td><input type="text" id="memo" name="memo" value="<%=setting.getMemo()%>"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="儲存">
				<input type="button" value="取消" onclick="cancelEdit()">
			</td>
		</tr>
	</table>
</div>
</form>
<br>
<script>
function cancelEdit()
{
	window.location.href="SystemParameterEdit.jsp";
}
</script>

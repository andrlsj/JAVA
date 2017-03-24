<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "db.manager.User"%>
<%@ page import="db.manager.UserManager"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<%
String userId ="";
User user = new User();
if(request.getParameter("id")!=null)
{
	userId = request.getParameter("id").toString();
	user = UserManager.getUserById(conn, userId);
}
%>
<br>
<form id="form1" action="UserEdit_controller.jsp">
<div id="UserEdit" style="display:block">
	<table align="center" border="0px">
		<tr>
			<td>姓名</td>
			<td>
				<input type="hidden" id="method" name="method" value="edit">
				<input type="hidden" id="userid" name="userid" value="<%=user.getId()%>">
				<input type="text" id="username" name="username" value="<%=user.getName()%>">
			</td>
		</tr>

		<tr>
			<td>電子郵件</td>
			<td>
				<input type="text" id="email" name="email" value="<%=user.getEmail()%>">
			</td>
		</tr>	
		<tr>
			<td>分機</td>
			<td>
				<input type="text" id="tel" name="tel" value="<%=user.getTel()%>">
			</td>
		</tr>	
		<tr>
			<td>性別</td>
			<td>
				<input type="text" id="sex" name="sex" value="<%=user.getSex()%>">
			</td>
		</tr>	
		<tr>
			<td>備註</td>
			<td><input type="text" id="memo" name="memo" value="<%=user.getMemo()%>"></td>
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
	window.location.href="UserManage.jsp";
}
</script>

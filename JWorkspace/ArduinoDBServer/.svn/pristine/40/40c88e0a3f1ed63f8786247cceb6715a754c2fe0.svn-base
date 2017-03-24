<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="head.jsp"%>      --%>
<%@ page import="java.util.HashMap" %>
<%
String Message = "";
if(session.getAttribute("Message")!=null)
	Message = session.getAttribute("Message").toString();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="./js/jquery-1.11.1.js"></script>
</head>
<style>
body, table, tr, td, input
{
	font-family:verdana;
	font-size:18px;
	color:black;
}
</style>
<body>
<form id="form1" action="login_controller.jsp">	
<table style="width: 100%;">
	<tr>
		<td>
			<table style="width: 300px; margin: auto; font-size:5">
				<tr>
					<td colspan="2" nowrap>
						<h1>環控系統 ArduinoDBServer 參數管理</h1>					
					</td>
				</tr>
				<tr>
					<td Colspan="2" style="text-align:center">
						<font color="red"><%=Message%></font>
					</td>
				</tr>
				<tr>
					<td width="20%" nowrap>
						帳號:
					</td>
					<td width="85%">
						<input type="text" id="account" name="account" size="15">
					</td>
				</tr>
				<tr>
					<td>
						密碼:
					</td>
					<td>
						<input type="password" id="password" name="password" size="15">
					</td>
				</tr>	
				<tr>
					<td colspan="2">										
					</td>
				</tr>				
				<tr>
					<td>
					</td>
					<td>
						<input type="button" id="login_submit" value="登入" onclick="login()">
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>					
			</table>
		</td>
	</tr>
</table>
<br><br>
<table width="80%" align="center">
<tr>
	<td colspan="2" align="center"><a href="http://192.168.4.161:8090/admin">廠區環境監控服務器管理</td>	
	<td colspan="2" align="center"><a href="http://192.168.4.162/envreports/chart">集團廠區環境監控總覽</td>		
</tr>
<tr>
		<td><a href="http://192.168.1.221:8092" target="_blank">正美總部(CHQ)</a></td>
		<td><a href="http://192.168.1.221:8091" target="_blank">台北廠(CCM)</a></td>
		<td><a href="http://10.3.6.30:8092" target="_blank">上海廠(CCW)</a></td>
		<td><a href="http://192.168.4.162:8092">昆山廠(CHK)</a></td>

		<td><a href="http://10.12.0.102:8092">天津廠(CZH)</a></td>	
	</tr>
	<tr>
		<td><a href="http://192.168.8.25:8092">煙台廠(CZZ)</a></td>
		<td><a href="http://192.168.12.25:8092">河南廠(CZM)</a></td>
		<td><a href="http://192.168.11.27:8092">重慶廠(CZY)</a></td>	
		<td><a href="http://192.168.3.103:8092">深圳廠(CZF)</a></td>	
		<td><a href="http://192.168.17.24:8092">廣東廠(CZB)</a></td>
		<td><a href=""></a></td>
	</tr>
</table>	
</form>
</body>
</html>
<script>
var account = document.getElementById("account");
var password = document.getElementById("password");
var login_submit = document.getElementById("login_submit");
account.addEventListener("keypress", function() {
    if (event.keyCode == 13) login_submit.click();
});
password.addEventListener("keypress", function() {
    if (event.keyCode == 13) login_submit.click();
});

function login()
{
	var id = document.getElementById("account").value;
	var password = document.getElementById("password").value;
	if(id=="" || password=="")
	{
		alert("請輸入帳號密碼!!");
		return;
	}else{
		var form1=document.getElementById("form1");
		//alert("submit");
		form1.submit();
	}
}
</script>

<%-- <%@ include file="foot.jsp"%>  --%>
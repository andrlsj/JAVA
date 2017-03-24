<% 
String Message="";
if(session.getAttribute("Message")!=null)
	Message = session.getAttribute("Message").toString();
%>
<table align="center">
	<tr>
		<td>
			<font color="red">
				<%=Message%>
			</font>
		</td>
	</tr>
</table>
<%
session.setAttribute("Message", null);
%>
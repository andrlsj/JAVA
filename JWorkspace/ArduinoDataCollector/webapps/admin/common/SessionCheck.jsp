<%
if(session.getAttribute("account")==null)
{
	session.invalidate();
	response.sendRedirect("login.jsp");
}
%>
<%@page import="java.io.*"%>

<%
String strFileName=request.getParameter("url").toString();
String strPath = new File(application.getRealPath(request.getRequestURI())).getParent();
strPath = strPath +"/" + strFileName;
System.out.println(strPath);
File file = new File(strPath);
if(file.exists())
{
	response.sendRedirect(strFileName);
}else{
	%>
<Script>
	alert("not exist");
	window.close();
</Script>
	
<%
}
%>
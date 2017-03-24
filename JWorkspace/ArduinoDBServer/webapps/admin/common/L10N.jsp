<%@ page import = "java.util.ResourceBundle"%>
<%@ page import = "java.util.Locale"%>
<%@ page import="data.GetData.GetData"%>
<%
Locale locale = null;
if(session.getAttribute("Locale")!=null)
{
	locale =(Locale)session.getAttribute("Locale");
}else{
	locale = Locale.TAIWAN;
}
//System.out.println(locale);
ResourceBundle rb = null;
if(session.getAttribute("ResourceBundle")!=null)
{
	rb = (ResourceBundle)session.getAttribute("ResourceBundle");
}else{
	rb = ResourceBundle.getBundle("messages", locale);
}

%>
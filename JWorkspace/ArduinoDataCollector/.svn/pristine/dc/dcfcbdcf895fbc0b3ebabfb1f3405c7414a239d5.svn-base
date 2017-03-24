<%@ page import = "db.dbmanager.SQLiteManager" %>
<%@ page import = "db.manager.SettingManager" %>
<%@ page import = "db.manager.Setting" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.sql.Connection" %>
<%
Connection conn = null;
HashMap<String,String> hmConfig = (HashMap<String,String>)application.getAttribute("hmConfig");
if(hmConfig ==null)
{
	hmConfig = SettingManager.getConfigHM();
	application.setAttribute("hmConfig", hmConfig);
}

if(application.getAttribute("Conn")==null)
{
	conn = SQLiteManager.getConnection();
	application.setAttribute("Conn", conn);
}else{
	conn = (Connection)application.getAttribute("Conn");	
}
	
int iPageRows=20;
%>
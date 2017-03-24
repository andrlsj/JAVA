<%@ page import = "db.dbmanager.SQLiteManager" %>
<%@ page import = "db.manager.SettingManager" %>
<%@ page import = "db.manager.Setting" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "db.dbmanager.DatabaseManagerC3P0" %>
<%
Connection sqliteConn = null;
Connection conn = null;
HashMap<String,String> hmConfig = (HashMap<String,String>)application.getAttribute("hmConfig");
if(hmConfig ==null)
{
	hmConfig = SettingManager.getConfigHM();
	application.setAttribute("hmConfig", hmConfig);
}

// if(application.getAttribute("SQLiteConn")==null)
// {
// 	sqliteConn = SQLiteManager.getConnection(hmConfig.get("SQLiteDBUrl").toString());
// 	application.setAttribute("SQLiteConn", sqliteConn);
// }else{
// 	sqliteConn = (Connection)application.getAttribute("SQLiteConn");	
// }
// if(application.getAttribute("Conn")==null)
// {
// 	OracleManagerC3P0 c3p0 = OracleManagerC3P0.getInstance();
// 	conn = c3p0.getConnection();
// 	application.setAttribute("Conn", conn);
// }else{
// 	conn = (Connection)application.getAttribute("Conn");	
// }
	
int iPageRows=20;
%>
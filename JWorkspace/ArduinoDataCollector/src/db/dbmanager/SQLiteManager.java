package db.dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class SQLiteManager 
{
	   public static Connection getConnection(String strDBFile) throws SQLException
	   {
	        SQLiteConfig config = new SQLiteConfig();
	        // config.setReadOnly(true);   
	        config.setSharedCache(true);
	        config.enableRecursiveTriggers(true); 
	        SQLiteDataSource ds = new SQLiteDataSource(config); 
	        ds.setUrl("jdbc:sqlite:" + strDBFile);
	        return ds.getConnection();
	   }
	   
	   public static Connection getConnection()
	   {
		    HashMap<String, String> hm = new HashMap<String, String>();
	        hm.put("Url", "db/ArduinoDataCollector.db");
	        SQLiteConfig config = new SQLiteConfig();
	        // config.setReadOnly(true);   
	        config.setSharedCache(true);
	        config.enableRecursiveTriggers(true); 
	        SQLiteDataSource ds = new SQLiteDataSource(config); 
	        ds.setUrl("jdbc:sqlite:" + hm.get("Url"));
	        Connection conn = null;
	        try {
	        	conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return conn;
	    }	   
	   	
	    //create Table
//	    public void createTable(Connection con)throws SQLException{
//	        String sql = "DROP TABLE IF EXISTS test ;create table test (id integer, name string); ";
//	        Statement stat = null;
//	        stat = con.createStatement();
//	        stat.executeUpdate(sql);
//	 
//	    }
	    //drop table
//	    public void dropTable(Connection con)throws SQLException{
//	        String sql = "drop table test ";
//	        Statement stat = null;
//	        stat = con.createStatement();
//	        stat.executeUpdate(sql);
//	    }
	 
	    //新增
//	    public void insert(Connection con,String strSQL)throws SQLException{
//	        String sql = "insert into test (id,name) values(?,?)";
//	        PreparedStatement pst = null;
//	        pst = con.prepareStatement(sql);
//	        int idx = 1 ; 
//	        pst.setInt(idx++, id);
//	        pst.setString(idx++, name);
//	        pst.executeUpdate();
//	 
//	    }
	    private static void InsertUpdateDelete(Connection conn, String strSQL)throws SQLException{
	        PreparedStatement pst = conn.prepareStatement(strSQL);
	        pst.executeUpdate();	 
	    }
	    public static void insert(Connection conn, String strSQL)throws SQLException
	    {	        
	    	InsertUpdateDelete(conn, strSQL);
	    }
	    //修改
	    public static void update(Connection conn, String strSQL)throws SQLException
	    {	        
	    	InsertUpdateDelete(conn, strSQL);
	    }
	    //刪除
	    public static void delete(Connection conn, String strSQL)throws SQLException
	    {
	    	InsertUpdateDelete(conn, strSQL);
	    }
	 
	    public static ResultSet select(Connection con, String strSQL)throws SQLException
	    {
	        Statement stat = con.createStatement();
	        ResultSet rs = stat.executeQuery(strSQL);
	        return rs;
	    }
}

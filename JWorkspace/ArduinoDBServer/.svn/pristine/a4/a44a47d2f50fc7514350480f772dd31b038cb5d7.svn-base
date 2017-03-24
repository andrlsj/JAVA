package db.dbmanager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import db.manager.SettingManager;

//import org.apache.log4j.xml.DOMConfigurator;

public class OracleManagerDBCP {
	private static Logger logger = Logger.getLogger(OracleManagerDBCP.class);
	private static OracleManagerDBCP instance;
	private static DataSource dataSource = null;
	public static Connection conn = null;
	private static HashMap<String, String> hm = null;
	
	public OracleManagerDBCP(HashMap<String, String> hm) {
		conn = getConnection(hm);
	}

	public OracleManagerDBCP() {
	}

	public Connection getConnection(){
		if(conn==null)
		{
			if(dataSource!=null)
			{
				try {
					conn = dataSource.getConnection();
					if(conn.isClosed())
					{
						dataSource = null;
						hm =  SettingManager.getConfigHM();
						conn = getConnection(hm);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				hm =  SettingManager.getConfigHM();
				conn = getConnection(hm);
			}
		}
		return conn;
	}

	public static Connection getConnection(HashMap<String, String> hm) {
		Connection con = null;
		try {
			logger.info(hm.toString());
			Class.forName(hm.get("Driver").toString());
			if (dataSource == null) {
				dataSource = setupDataSource(hm.get("Driver").toString(), hm
						.get("Account").toString(), hm.get("Password")
						.toString(), hm.get("Url").toString());
			}
			con = (Connection) dataSource.getConnection();
			if(con.isClosed())
			{
				dataSource=null;
				con=getConnection(hm);
			}
		} catch (ClassNotFoundException e) {
			logger.error("DriverClassNotFound :" + e.toString());
		} catch (SQLException x) {
			logger.error("SQLException :" + x.toString());
		}
		return con;
	}

	private static DataSource setupDataSource(String sDrvName, String sUserName, String sPwd, String connectURI) 
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(sDrvName);
		ds.setUsername(sUserName);
		ds.setPassword(sPwd);
		ds.setUrl(connectURI);
		ds.setMaxIdle(10);
		ds.setAccessToUnderlyingConnectionAllowed(true);
		return ds;
	}
	
	public static OracleManagerDBCP getInstance() {
		synchronized (OracleManagerDBCP.class) {
			if (instance == null) {
				instance = new OracleManagerDBCP();
			}
		}
		return instance;
	}
	public void closeDataSource() {
		try {
			dataSource.getClass().getMethod("close").invoke(dataSource);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reset() {
		closeDataSource();
	}

}

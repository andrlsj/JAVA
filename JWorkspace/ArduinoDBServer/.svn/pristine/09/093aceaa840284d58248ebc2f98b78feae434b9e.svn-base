package db.dbmanager;

import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import SQLite.manager.SettingManager;
import Util.PropertiesUtil;
//import org.apache.log4j.xml.DOMConfigurator;

public class DatabaseManagerC3P0 {
	private static Logger logger = Logger.getLogger(DatabaseManagerC3P0.class);
	private static DatabaseManagerC3P0 instance;
	private static ComboPooledDataSource dataSource = null;
	private static HashMap<String, String> hm = null;
	private static final String configFile = "./config/c3p0.properties";

	public DatabaseManagerC3P0() {
		DOMConfigurator.configure("./config/log4j.xml");
	}

	public static DatabaseManagerC3P0 getInstance() {
		synchronized (DatabaseManagerC3P0.class) {
			if (instance == null) {
				instance = new DatabaseManagerC3P0();
			}
		}
		return instance;
	}

	public void reset() {
		closeDataSource();
	}

	public Connection getConnection() {
		if (dataSource == null) {
			hm = SettingManager.getConfigHM();
			int iMaxPool = Integer.parseInt(hm.get("MaxConnectionPool"));
			dataSource = setupDataSource(hm.get("Driver").toString(), hm.get("Account").toString(),
					hm.get("Password").toString(), hm.get("Url").toString(), iMaxPool);
		}
		// printDataSourceStats();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public Connection getConnection(HashMap<String, String> hm) {
		Connection con = null;
		try {
			logger.info(hm.toString());
			Class.forName(hm.get("Driver").toString());
			if (dataSource == null) {
				int iMaxPool = Integer.parseInt(hm.get("MaxConnectionPool"));
				dataSource = setupDataSource(hm.get("Driver").toString(), hm.get("Account").toString(),
						hm.get("Password").toString(), hm.get("Url").toString(), iMaxPool);
			}
			con = (Connection) dataSource.getConnection();
		} catch (ClassNotFoundException e) {
			logger.error("DriverClassNotFound :" + e.toString());
		} catch (SQLException x) {
			logger.error("SQLException :" + x.toString());
		}
		return con;
	}

	protected synchronized ComboPooledDataSource setupDataSource(String sDrvName, String sUserName, String sPwd,
			String connectURI, int iMaxPool) {
		ComboPooledDataSource ds = null;
		try {
			ds = new ComboPooledDataSource();
			ds.setDriverClass(sDrvName);
			ds.setJdbcUrl(connectURI);
			ds.setUser(sUserName);
			ds.setPassword(sPwd);
			ds.setMaxPoolSize(iMaxPool);

			Properties p = PropertiesUtil.readPropertiesFile(configFile);

			ds.setInitialPoolSize(Integer.parseInt((String) p.get("initialPoolSize")));
			ds.setMinPoolSize(Integer.parseInt((String) p.get("minPoolSize")));
			ds.setAcquireIncrement(Integer.parseInt((String) p.get("acquireIncrement")));
			ds.setAutoCommitOnClose(Boolean.parseBoolean((p.get("autoCommitOnClose").toString())));
			ds.setMaxIdleTime(Integer.parseInt(p.getProperty("maxIdleTime")));
			ds.setAcquireRetryDelay(Integer.parseInt((String) p.get("acquireRetryDelay")));
			ds.setBreakAfterAcquireFailure(Boolean.parseBoolean((p.get("breakAfterAcquireFailure").toString())));
			ds.setCheckoutTimeout(Integer.parseInt((String) p.get("checkoutTimeout")));
			ds.setIdleConnectionTestPeriod(Integer.parseInt((String) p.get("idleConnectionTestPeriod")));
			ds.setNumHelperThreads(Integer.parseInt((String) p.get("numHelperThreads")));
			ds.setPropertyCycle(Integer.parseInt((String) p.get("propertyCycle")));
			ds.setMaxStatements(Integer.parseInt((String) p.get("maxStatements")));
			ds.setDebugUnreturnedConnectionStackTraces(true);

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		//printDataSourceStats();
		return ds;
	}

	protected synchronized ComboPooledDataSource setupDataSource() {
		ComboPooledDataSource ds = null;
		ds = new ComboPooledDataSource();

		Properties p = PropertiesUtil.readPropertiesFile(configFile);
		
		 try {
			ds.setDriverClass((String)p.get("database.driverClassName"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ds.setJdbcUrl((String) p.get("jdbc.url"));
		 ds.setUser((String) p.get("jdbc.username"));
		 ds.setPassword((String) p.get("jdbc.password"));
		ds.setInitialPoolSize(Integer.parseInt((String) p.get("initialPoolSize")));
		ds.setMaxPoolSize(Integer.parseInt((String) p.get("maxPoolSize")));
		ds.setMinPoolSize(Integer.parseInt((String) p.get("minPoolSize")));
		ds.setAcquireIncrement(Integer.parseInt((String) p.get("acquireIncrement")));
		ds.setAutoCommitOnClose(Boolean.parseBoolean((p.get("autoCommitOnClose").toString())));
		ds.setMaxIdleTime(Integer.parseInt(p.getProperty("maxIdleTime")));
		ds.setAcquireRetryDelay(Integer.parseInt((String) p.get("acquireRetryDelay")));
		ds.setBreakAfterAcquireFailure(Boolean.parseBoolean((p.get("breakAfterAcquireFailure").toString())));
		ds.setCheckoutTimeout(Integer.parseInt((String) p.get("checkoutTimeout")));
		ds.setIdleConnectionTestPeriod(Integer.parseInt((String) p.get("idleConnectionTestPeriod")));
		ds.setNumHelperThreads(Integer.parseInt((String) p.get("numHelperThreads")));
		ds.setPropertyCycle(Integer.parseInt((String) p.get("propertyCycle")));
		ds.setMaxStatements(Integer.parseInt((String) p.get("maxStatements")));
		ds.setDebugUnreturnedConnectionStackTraces(true);
		return ds;
	}
	
	public void printDataSourceStats() {
		if(dataSource==null)
			return;
		try {
			logger.info("DataSourceName:  " + dataSource.getDataSourceName() + "\nNumActive:  "
					+ dataSource.getThreadPoolNumActiveThreads() + "\nNumIdle:  " + dataSource.getNumBusyConnections()
					+ "\nMaxStatements:" + dataSource.getMaxStatements() + "\nMaxStatementsPerConnection: "
					+ dataSource.getMaxStatementsPerConnection() + "\nMaxPoolSize: " + dataSource.getMaxPoolSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		// dataSource.close();
	}

}

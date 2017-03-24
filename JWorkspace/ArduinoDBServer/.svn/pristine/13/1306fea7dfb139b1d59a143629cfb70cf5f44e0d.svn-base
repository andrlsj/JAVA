package db.dbmanager;

import java.sql.Connection;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class SQLiteManager {
	//private static Logger logger = Logger.getLogger(SQLiteManager.class);
	private static SQLiteManager instance;
	private static SQLiteDataSource dataSource = null;
	public static Connection conn = null;

	public static Connection getConnection(String strDBFile) {
		if (dataSource == null) {
			setupDataSource(strDBFile);
		}
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void setupDataSource()
	{
		setupDataSource("db/ArduinoDBServer.db");
	}

	private static void setupDataSource(String strDBFile) {
		if (dataSource == null) {
			SQLiteConfig config = new SQLiteConfig();
			config.setSharedCache(true);
			config.enableRecursiveTriggers(true);
			dataSource = new SQLiteDataSource(config);
			dataSource.setUrl("jdbc:sqlite:" + strDBFile);
		}
	}

	public Connection getConnection(){
		if(dataSource ==null)
			setupDataSource();
		Connection conn = null;
		try {
			conn= dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static SQLiteManager getInstance() {
		synchronized (SQLiteManager.class) {
			if (instance == null) {
				instance = new SQLiteManager();
			}
		}
		return instance;
	}

	// create Table
	// public void createTable(Connection con)throws SQLException{
	// String sql = "DROP TABLE IF EXISTS test ;create table test (id integer,
	// name string); ";
	// Statement stat = null;
	// stat = con.createStatement();
	// stat.executeUpdate(sql);
	//
	// }
	// drop table
	// public void dropTable(Connection con)throws SQLException{
	// String sql = "drop table test ";
	// Statement stat = null;
	// stat = con.createStatement();
	// stat.executeUpdate(sql);
	// }

	// 新增
	// public void insert(Connection con,String strSQL)throws SQLException{
	// String sql = "insert into test (id,name) values(?,?)";
	// PreparedStatement pst = null;
	// pst = con.prepareStatement(sql);
	// int idx = 1 ;
	// pst.setInt(idx++, id);
	// pst.setString(idx++, name);
	// pst.executeUpdate();
	//
	// }
//	private static void InsertUpdateDelete(Connection conn, String strSQL) throws SQLException {
//		PreparedStatement pst = conn.prepareStatement(strSQL);
//		pst.executeUpdate();
//	}
//
//	public static void insert(Connection conn, String strSQL) throws SQLException {
//		InsertUpdateDelete(conn, strSQL);
//	}
//
//	// 修改
//	public static void update(Connection conn, String strSQL) throws SQLException {
//		InsertUpdateDelete(conn, strSQL);
//	}
//
//	// 刪除
//	public static void delete(Connection conn, String strSQL) throws SQLException {
//		InsertUpdateDelete(conn, strSQL);
//	}
//
//	public static ResultSet select(Connection con, String strSQL) throws SQLException {
//		Statement stat = con.createStatement();
//		ResultSet rs = stat.executeQuery(strSQL);
//		return rs;
//	}
}

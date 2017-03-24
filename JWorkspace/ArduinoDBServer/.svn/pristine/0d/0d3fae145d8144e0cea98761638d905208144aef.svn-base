package db.dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class DatabaseManagerBase {
	private static Logger logger = Logger.getLogger(DatabaseManagerBase.class);

	public DatabaseManagerBase() {
		DOMConfigurator.configure("./config/log4j.xml");
	}

	public static int Insert(Connection conn, String strQry) {
		return InsertUpdateDelete(conn, strQry);
	}

	public static int Update(Connection conn, String strQry) {
		return InsertUpdateDelete(conn, strQry);
	}

	public static int Delete(Connection conn, String strQry) {
		return InsertUpdateDelete(conn, strQry);
	}

	private static int InsertUpdateDelete(Connection conn, String strQry) {
		int iResult = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(strQry);
			iResult = statement.executeUpdate();
			Close(null, null, statement);
		} catch (SQLException se) {
			logger.error(se.toString());
		}
		Close(null, null, null, conn);
		return iResult;
	}

	public static void Close(ResultSet rs, Statement stat, PreparedStatement pst) {
		Close(rs, stat, pst, null);
	}

	public static void Close(ResultSet rs, Statement stat, PreparedStatement pst, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (pst != null) {
				pst.close();
				pst = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			logger.error("Close Exception :" + e.toString());
		}
	}

	public static ResultSet Select(Connection con, String strSQL) throws SQLException {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(strSQL);
		return rs;
	}
}

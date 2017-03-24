package SQLite.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.Sql.SQLiteBase;
import data.Sql.SQLiteBase.SQLInserter;
import data.Sql.SQLiteBase.SQLSelecter;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.SQLiteManager;
import db.manager.SNC01;

public class SNC01Manager {
	private static Logger logger = Logger.getLogger(SNC01Manager.class);
	public static boolean Save(SNC01 snc) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		boolean bResult = false;
		SQLInserter ins = new SQLiteBase.SQLInserter("SNC01");
		ins.addStrValue("SNC01_01", snc.getMachineName());
		ins.addStrValue("SNC01_02", snc.getIp());
		ins.addStrValue("SNC01_03", snc.getCompanyId());
		ins.addStrValue("SNC01_04", snc.getMemo());		
		logger.info(ins.toString());
		DatabaseManagerBase.Insert(conn, ins.toString());
		bResult = true;
		return bResult;
	}
	
	public static List<SNC01> getSNCX01s()
	{
		return getSNCX01s(null);
	}

	public static List<SNC01> getSNCX01s(SNC01 snc01) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLSelecter sel = new SQLiteBase.SQLSelecter("SNC01");
		sel.addSelect("*");
		sel.addStrCond("snc01_05", "1");
		if(snc01!=null)
		{
			if(snc01.getCompanyId()!=null)	
			{
				if(!snc01.getCompanyId().equals(""))
				{
					sel.addCond("SNC01_03",snc01.getCompanyId());
				}
			}
			if(snc01.getMachineName()!=null)	
			{
				if(!snc01.getMachineName().equals(""))
				{
					sel.addLikeCond("SNC01_01",snc01.getMachineName());
				}
			}
			if(snc01.getIp()!=null)	
			{
				if(!snc01.getIp().equals(""))
				{
					sel.addLikeCond("SNC01_02",snc01.getIp());
				}
			}
		}
		
		List<SNC01> lstSNCX01 = new ArrayList<SNC01>();
		logger.info(sel.toString());
		try {
			PreparedStatement stat = conn.prepareStatement(sel.toString());
			ResultSet rs = stat.executeQuery();	
			while (rs.next()) {
				SNC01 snc = new SNC01();
				snc.setMachineName(rs.getString("SNC01_01"));
				snc.setIp(rs.getString("SNC01_02"));
				snc.setCompanyId(rs.getString("SNC01_03"));
				snc.setMemo(rs.getString("SNC01_04"));
				lstSNCX01.add(snc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lstSNCX01;
	}
}

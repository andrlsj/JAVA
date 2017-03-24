package OracleDB.manager;

import Util.DateUtil;
import data.Sql.OracleSQLBase;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.DatabaseManagerC3P0;
import db.manager.SNC02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class SNC02Manager
{
  private static Logger logger = Logger.getLogger(SNC02Manager.class);
  
  public static void main(String[] args) throws SQLException
  {
	  List<SNC02> lst = getRecentSNCX02s("CZF");
	  System.out.println(lst.size());
  }
  
  public static boolean save(SNC02 snc)
  {
    boolean bResult = false;
	DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
	Connection conn = dbcp.getConnection();
    OracleSQLBase.SQLInserter ins = new OracleSQLBase.SQLInserter("SNC02");
    ins.addStrValue("SNC02_01", snc.getSncx02_01());
    ins.addStrValue("SNC02_02", snc.getSncx02_02());
    ins.addFloatValue("SNC02_03", snc.getSncx02_03());
    ins.addStrValue("SNC02_04", snc.getSncx02_04());
    ins.addSysdateValue("SNC02_05");
    logger.info(ins.toString());
    DatabaseManagerBase.Insert(conn, ins.toString());
    DatabaseManagerBase.Close(null, null, null,conn);
    bResult = true;
    return bResult;
  }
  
  public static List<SNC02> getSNCX02s()
  {
	DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
	Connection conn = dbcp.getConnection();
    OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC02");
    sel.addSelect("*");
    
    List<SNC02> lstSNCX02 = new ArrayList<SNC02>();
    logger.info(sel.toString());
    try
    {
      PreparedStatement pst = conn.prepareStatement(sel.toString());
      ResultSet rs = pst.executeQuery();
      while (rs.next())
      {
        SNC02 snc = new SNC02();
        snc.setSncx02_01(rs.getString("SNC02_01"));
        snc.setSncx02_02(rs.getString("SNC02_02"));
        snc.setSncx02_03(rs.getInt("SNC02_03"));
        snc.setSncx02_04(rs.getString("SNC02_04"));
        lstSNCX02.add(snc);
      }
      DatabaseManagerBase.Close(rs, null, pst);
    }
    catch (SQLException e)
    {
      logger.error(e.toString());
    }finally{
    	DatabaseManagerBase.Close(null, null, null, conn);
    }
    return lstSNCX02;
  }
  
  public static List<SNC02> getRecentSNCX02s(String strCompanyId)
  {
	  DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
	  Connection conn = dbcp.getConnection();
    OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC02");
    sel.addSelect("*");
    sel.addStrGreaterCond("snc02_04", DateUtil.getCymmetrikDateTime(DateUtil.addDay(new Date(),-1)));
    sel.addLikeCond("snc02_01", strCompanyId + "%");
    sel.addOrderDesc("snc02_04");
    List<SNC02> lstSNCX02 = new ArrayList<SNC02>();
    logger.info(sel.toString());
    try
    {
      PreparedStatement pst = conn.prepareStatement(sel.toString());
      ResultSet rs = pst.executeQuery();
      while (rs.next())
      {
        SNC02 snc = new SNC02();
        snc.setSncx02_01(rs.getString("SNC02_01"));
        snc.setSncx02_02(rs.getString("SNC02_02"));
        snc.setSncx02_03(rs.getInt("SNC02_03"));
        snc.setSncx02_04(rs.getString("SNC02_04"));
        lstSNCX02.add(snc);
      }
      DatabaseManagerBase.Close(rs, null, pst);
    }
    catch (SQLException e)
    {
      logger.error(e.toString());
    }finally{
    	DatabaseManagerBase.Close(null, null, null, conn);
    }
    return lstSNCX02;
  }
}

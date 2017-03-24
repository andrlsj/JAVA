package db.manager;

import data.Sql.SQLiteBase;
import db.dbmanager.SQLiteManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorDataManager
{
  public static boolean save(Connection conn, SensorData sd)
  {
      boolean bResult = false;
      SQLiteBase.SQLInserter ins = new SQLiteBase.SQLInserter("sensordata");
      ins.addStrValue("machine_id", sd.getMachineId());
      ins.addStrValue("sensor_type", sd.getSensorType());
      ins.addFloatValue("value", sd.getValue());
      ins.addStrValue("system_dt", sd.getSystemDT());
      try
      {
        System.out.println(ins.toString());
        SQLiteManager.insert(conn, ins.toString());
        bResult = true;
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      return bResult;
  }
  
  public static boolean updateTransferred(Connection conn, int iSensorDataId)
  {
    boolean bResult = false;
    SensorData sd0 = getSensorDataById(conn, iSensorDataId);
    if (!sd0.getMachineId().equals(""))
    {
      SQLiteBase.SQLUpdater upd = new SQLiteBase.SQLUpdater("sensordata");
      upd.updateIntField("transferred", 1);
      upd.addIntCond("id", iSensorDataId);
      try
      {
        System.out.println(upd.toString());
        SQLiteManager.update(conn, upd.toString());
        bResult = true;
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    return bResult;
  }
  
  public static SensorData getSensorDataById(Connection con, int iSensorDataId)
  {
    SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("sensordata");
    sel.addSelect("*");
    sel.addIntCond("id", iSensorDataId);
    SensorData sd = new SensorData();
    try
    {
      System.out.println(sel.toString());
      ResultSet rs = SQLiteManager.select(con, sel.toString());
      while (rs.next())
      {
        sd.setId(rs.getInt("id"));
        sd.setMachineId(rs.getString("machine_id"));
        sd.setSensorType(rs.getString("sensor_type"));
        sd.setValue(rs.getFloat("value"));
        sd.setSystemDT(rs.getString("system_dt"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return sd;
  }
    
  public static List<SensorData> getSensorDataNotTransferred(Connection conn)
  {
    String strSQL = "Select *  FROM sensordata Where transferred <> 1";
    List<SensorData> lstSensorData = new ArrayList<SensorData>();
    System.out.println(strSQL);
    try
    {
      ResultSet rs = SQLiteManager.select(conn, strSQL);
      while (rs.next())
      {
    	SensorData sd = new SensorData();
        sd.setId(rs.getInt("id"));
        sd.setMachineId(rs.getString("machine_id"));
        sd.setSensorType(rs.getString("sensor_type"));
        sd.setValue(rs.getFloat("value"));
        sd.setSystemDT(rs.getString("system_dt"));
        sd.setTransferred(rs.getBoolean("transferred"));
        lstSensorData.add(sd);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return lstSensorData;
  }
}

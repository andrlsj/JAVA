package db.manager;

import java.util.Date;

public class Setting
{
  private String id = "";
  private String sysname = "";
  private String name = "";
  private String value = "";
  private boolean enable;
  private Date datetime;
  private String memo = "";
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getSysname()
  {
    return this.sysname;
  }
  
  public void setSysname(String sysname)
  {
    this.sysname = sysname;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean enable)
  {
    this.enable = enable;
  }
  
  public Date getDatetime()
  {
    return this.datetime;
  }
  
  public void setDatetime(Date datetime)
  {
    this.datetime = datetime;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String memo)
  {
    this.memo = memo;
  }
  
  public String toString()
  {
    return 
    
      "Setting [id=" + this.id + ", sysname=" + this.sysname + ", name=" + this.name + ", value=" + this.value + ", enable=" + this.enable + ", datetime=" + this.datetime + ", memo=" + this.memo + "]";
  }
}

package WebService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import db.manager.SNC02;

@WebService
public abstract interface ISNC02Manager
{
  @WebMethod
  public abstract boolean SaveSNC02(@WebParam(name="snc") SNC02 paramSNC02);
  
  @WebMethod
  public abstract List<SNC02> getRecentSNCX02s(@WebParam(name="strCompanyId") String strCompanyId);
}

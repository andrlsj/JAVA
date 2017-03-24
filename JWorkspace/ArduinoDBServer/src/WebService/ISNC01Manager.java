package WebService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import db.manager.SNC01;

@WebService
public abstract interface ISNC01Manager
{
  @WebMethod
  public abstract boolean SaveSNC01(@WebParam(name="snc") SNC01 paramSNC01);
  
  @WebMethod
  public abstract List<SNC01> getAllSNCX01s();
  
  @WebMethod
  public abstract List<SNC01> getSNCX01s(@WebParam(name="snc") SNC01 paramSNC01);
  
  @WebMethod
  public abstract List<SNC01> getSNCX01sByMins(@WebParam(name="snc") SNC01 paramSNC01);
    
  @WebMethod
  public abstract SNC01 getSNCX01ByMachineName(@WebParam(name="strMachineName") String paramString);
}

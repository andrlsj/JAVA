package snc02ManagerWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.15
 * 2015-07-20T08:30:33.645+08:00
 * Generated source version: 2.7.15
 * 
 */
@WebService(targetNamespace = "http://WebService/", name = "ISNC02Manager")
@XmlSeeAlso({ObjectFactory.class})
public interface ISNC02Manager {

    @WebMethod(operationName = "SaveSNC02")
    @RequestWrapper(localName = "SaveSNC02", targetNamespace = "http://WebService/", className = "snc02ManagerWebService.SaveSNC02")
    @ResponseWrapper(localName = "SaveSNC02Response", targetNamespace = "http://WebService/", className = "snc02ManagerWebService.SaveSNC02Response")
    @WebResult(name = "return", targetNamespace = "")
    public boolean saveSNC02(
        @WebParam(name = "snc", targetNamespace = "")
        snc02ManagerWebService.Snc02 snc
    );

    @WebMethod(operationName = "getRecentSNCX02s")
    @RequestWrapper(localName = "getRecentSNCX02s", targetNamespace = "http://WebService/", className = "snc02ManagerWebService.GetRecentSNCX02S")
    @ResponseWrapper(localName = "getRecentSNCX02sResponse", targetNamespace = "http://WebService/", className = "snc02ManagerWebService.GetRecentSNCX02SResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<snc02ManagerWebService.Snc02> getRecentSNCX02S(
        @WebParam(name = "strCompanyId", targetNamespace = "")
        java.lang.String strCompanyId
    );
}
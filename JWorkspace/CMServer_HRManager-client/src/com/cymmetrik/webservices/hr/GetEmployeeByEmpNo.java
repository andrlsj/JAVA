
package com.cymmetrik.webservices.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getEmployeeByEmpNo complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="getEmployeeByEmpNo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strEmpNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeByEmpNo", propOrder = {
    "strEmpNo"
})
public class GetEmployeeByEmpNo {

    protected String strEmpNo;

    /**
     * ���o strEmpNo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrEmpNo() {
        return strEmpNo;
    }

    /**
     * �]�w strEmpNo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrEmpNo(String value) {
        this.strEmpNo = value;
    }

}

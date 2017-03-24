
package com.cymmetrik.webservices.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getAllUnderEmployeesByCompanyNoDeptNo complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="getAllUnderEmployeesByCompanyNoDeptNo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strCompanyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strDeptNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllUnderEmployeesByCompanyNoDeptNo", propOrder = {
    "strCompanyNo",
    "strDeptNo",
    "strCriteria"
})
public class GetAllUnderEmployeesByCompanyNoDeptNo {

    protected String strCompanyNo;
    protected String strDeptNo;
    protected String strCriteria;

    /**
     * ���o strCompanyNo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCompanyNo() {
        return strCompanyNo;
    }

    /**
     * �]�w strCompanyNo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCompanyNo(String value) {
        this.strCompanyNo = value;
    }

    /**
     * ���o strDeptNo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDeptNo() {
        return strDeptNo;
    }

    /**
     * �]�w strDeptNo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDeptNo(String value) {
        this.strDeptNo = value;
    }

    /**
     * ���o strCriteria �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCriteria() {
        return strCriteria;
    }

    /**
     * �]�w strCriteria �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCriteria(String value) {
        this.strCriteria = value;
    }

}

package com.cymmetrik.webservices.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getDeptsByCompNoDeptNo complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="getDeptsByCompNoDeptNo">
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
@XmlType(name = "getDeptsByCompNoDeptNo", propOrder = {
    "strCompanyNo",
    "strDeptNo",
    "strCriteria"
})
public class GetDeptsByCompNoDeptNo {

    protected String strCompanyNo;
    protected String strDeptNo;
    protected String strCriteria;

    /**
     * 取得 strCompanyNo 特性的值.
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
     * 設定 strCompanyNo 特性的值.
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
     * 取得 strDeptNo 特性的值.
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
     * 設定 strDeptNo 特性的值.
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
     * 取得 strCriteria 特性的值.
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
     * 設定 strCriteria 特性的值.
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

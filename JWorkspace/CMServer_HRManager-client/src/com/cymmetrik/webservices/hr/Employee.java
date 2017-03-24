
package com.cymmetrik.webservices.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>employee complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobCate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobCateDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobPlaceDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
    "cardNo",
    "compId",
    "deptName",
    "deptNo",
    "effectDt",
    "email",
    "empName",
    "empNo",
    "jobCate",
    "jobCateDesc",
    "jobPlace",
    "jobPlaceDesc",
    "jobStatus",
    "sex"
})
public class Employee {

    protected String cardNo;
    protected String compId;
    protected String deptName;
    protected String deptNo;
    protected String effectDt;
    protected String email;
    protected String empName;
    protected String empNo;
    protected String jobCate;
    protected String jobCateDesc;
    protected String jobPlace;
    protected String jobPlaceDesc;
    protected int jobStatus;
    protected String sex;

    /**
     * 取得 cardNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 設定 cardNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNo(String value) {
        this.cardNo = value;
    }

    /**
     * 取得 compId 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompId() {
        return compId;
    }

    /**
     * 設定 compId 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompId(String value) {
        this.compId = value;
    }

    /**
     * 取得 deptName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 設定 deptName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * 取得 deptNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * 設定 deptNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptNo(String value) {
        this.deptNo = value;
    }

    /**
     * 取得 effectDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectDt() {
        return effectDt;
    }

    /**
     * 設定 effectDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectDt(String value) {
        this.effectDt = value;
    }

    /**
     * 取得 email 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * 設定 email 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 取得 empName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 設定 empName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpName(String value) {
        this.empName = value;
    }

    /**
     * 取得 empNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     * 設定 empNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpNo(String value) {
        this.empNo = value;
    }

    /**
     * 取得 jobCate 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobCate() {
        return jobCate;
    }

    /**
     * 設定 jobCate 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobCate(String value) {
        this.jobCate = value;
    }

    /**
     * 取得 jobCateDesc 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobCateDesc() {
        return jobCateDesc;
    }

    /**
     * 設定 jobCateDesc 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobCateDesc(String value) {
        this.jobCateDesc = value;
    }

    /**
     * 取得 jobPlace 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobPlace() {
        return jobPlace;
    }

    /**
     * 設定 jobPlace 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobPlace(String value) {
        this.jobPlace = value;
    }

    /**
     * 取得 jobPlaceDesc 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobPlaceDesc() {
        return jobPlaceDesc;
    }

    /**
     * 設定 jobPlaceDesc 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobPlaceDesc(String value) {
        this.jobPlaceDesc = value;
    }

    /**
     * 取得 jobStatus 特性的值.
     * 
     */
    public int getJobStatus() {
        return jobStatus;
    }

    /**
     * 設定 jobStatus 特性的值.
     * 
     */
    public void setJobStatus(int value) {
        this.jobStatus = value;
    }

    /**
     * 取得 sex 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * 設定 sex 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

}

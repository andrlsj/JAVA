
package com.cymmetrik.webservices.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>department complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="department">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptDeputyMgr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptDeputyMgr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptMgr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptMgrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptOrderBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dept_level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dept_level_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectDt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segSegmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "department", propOrder = {
    "deptDeputyMgr1",
    "deptDeputyMgr2",
    "deptMgr",
    "deptMgrName",
    "deptName",
    "deptNo",
    "deptOrderBy",
    "deptLevel",
    "deptLevelDesc",
    "effectDt",
    "level",
    "segSegmentNo",
    "upperDept"
})
public class Department {

    protected String deptDeputyMgr1;
    protected String deptDeputyMgr2;
    protected String deptMgr;
    protected String deptMgrName;
    protected String deptName;
    protected String deptNo;
    protected String deptOrderBy;
    @XmlElement(name = "dept_level")
    protected String deptLevel;
    @XmlElement(name = "dept_level_desc")
    protected String deptLevelDesc;
    protected String effectDt;
    protected String level;
    protected String segSegmentNo;
    protected String upperDept;

    /**
     * ���o deptDeputyMgr1 �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptDeputyMgr1() {
        return deptDeputyMgr1;
    }

    /**
     * �]�w deptDeputyMgr1 �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptDeputyMgr1(String value) {
        this.deptDeputyMgr1 = value;
    }

    /**
     * ���o deptDeputyMgr2 �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptDeputyMgr2() {
        return deptDeputyMgr2;
    }

    /**
     * �]�w deptDeputyMgr2 �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptDeputyMgr2(String value) {
        this.deptDeputyMgr2 = value;
    }

    /**
     * ���o deptMgr �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptMgr() {
        return deptMgr;
    }

    /**
     * �]�w deptMgr �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptMgr(String value) {
        this.deptMgr = value;
    }

    /**
     * ���o deptMgrName �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptMgrName() {
        return deptMgrName;
    }

    /**
     * �]�w deptMgrName �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptMgrName(String value) {
        this.deptMgrName = value;
    }

    /**
     * ���o deptName �S�ʪ���.
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
     * �]�w deptName �S�ʪ���.
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
     * ���o deptNo �S�ʪ���.
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
     * �]�w deptNo �S�ʪ���.
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
     * ���o deptOrderBy �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptOrderBy() {
        return deptOrderBy;
    }

    /**
     * �]�w deptOrderBy �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptOrderBy(String value) {
        this.deptOrderBy = value;
    }

    /**
     * ���o deptLevel �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptLevel() {
        return deptLevel;
    }

    /**
     * �]�w deptLevel �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptLevel(String value) {
        this.deptLevel = value;
    }

    /**
     * ���o deptLevelDesc �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptLevelDesc() {
        return deptLevelDesc;
    }

    /**
     * �]�w deptLevelDesc �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptLevelDesc(String value) {
        this.deptLevelDesc = value;
    }

    /**
     * ���o effectDt �S�ʪ���.
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
     * �]�w effectDt �S�ʪ���.
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
     * ���o level �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevel() {
        return level;
    }

    /**
     * �]�w level �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevel(String value) {
        this.level = value;
    }

    /**
     * ���o segSegmentNo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegSegmentNo() {
        return segSegmentNo;
    }

    /**
     * �]�w segSegmentNo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegSegmentNo(String value) {
        this.segSegmentNo = value;
    }

    /**
     * ���o upperDept �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpperDept() {
        return upperDept;
    }

    /**
     * �]�w upperDept �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpperDept(String value) {
        this.upperDept = value;
    }

}

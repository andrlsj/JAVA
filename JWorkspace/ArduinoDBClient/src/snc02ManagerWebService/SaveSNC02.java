
package snc02ManagerWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SaveSNC02 complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="SaveSNC02">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="snc" type="{http://WebService/}snc02" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveSNC02", propOrder = {
    "snc"
})
public class SaveSNC02 {

    protected Snc02 snc;

    /**
     * 取得 snc 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Snc02 }
     *     
     */
    public Snc02 getSnc() {
        return snc;
    }

    /**
     * 設定 snc 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Snc02 }
     *     
     */
    public void setSnc(Snc02 value) {
        this.snc = value;
    }

}


package snc01ManagerWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getSNCX01s complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="getSNCX01s">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="snc" type="{http://WebService/}snc01" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSNCX01s", propOrder = {
    "snc"
})
public class GetSNCX01S {

    protected Snc01 snc;

    /**
     * ���o snc �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link Snc01 }
     *     
     */
    public Snc01 getSnc() {
        return snc;
    }

    /**
     * �]�w snc �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link Snc01 }
     *     
     */
    public void setSnc(Snc01 value) {
        this.snc = value;
    }

}

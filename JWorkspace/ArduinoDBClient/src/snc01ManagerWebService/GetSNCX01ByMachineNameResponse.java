
package snc01ManagerWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getSNCX01ByMachineNameResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="getSNCX01ByMachineNameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://WebService/}snc01" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSNCX01ByMachineNameResponse", propOrder = {
    "_return"
})
public class GetSNCX01ByMachineNameResponse {

    @XmlElement(name = "return")
    protected Snc01 _return;

    /**
     * ���o return �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link Snc01 }
     *     
     */
    public Snc01 getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link Snc01 }
     *     
     */
    public void setReturn(Snc01 value) {
        this._return = value;
    }

}

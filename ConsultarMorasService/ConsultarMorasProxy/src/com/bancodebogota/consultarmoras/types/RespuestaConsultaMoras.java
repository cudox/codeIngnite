
package com.bancodebogota.consultarmoras.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaConsultaMoras complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaConsultaMoras">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaCod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="respuestaDat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respuestaMsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultaMoras", propOrder = {
    "respuestaCod",
    "respuestaDat",
    "respuestaMsj"
})
public class RespuestaConsultaMoras {

    protected int respuestaCod;
    protected String respuestaDat;
    protected String respuestaMsj;

    /**
     * Gets the value of the respuestaCod property.
     * 
     */
    public int getRespuestaCod() {
        return respuestaCod;
    }

    /**
     * Sets the value of the respuestaCod property.
     * 
     */
    public void setRespuestaCod(int value) {
        this.respuestaCod = value;
    }

    /**
     * Gets the value of the respuestaDat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespuestaDat() {
        return respuestaDat;
    }

    /**
     * Sets the value of the respuestaDat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespuestaDat(String value) {
        this.respuestaDat = value;
    }

    /**
     * Gets the value of the respuestaMsj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespuestaMsj() {
        return respuestaMsj;
    }

    /**
     * Sets the value of the respuestaMsj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespuestaMsj(String value) {
        this.respuestaMsj = value;
    }

}

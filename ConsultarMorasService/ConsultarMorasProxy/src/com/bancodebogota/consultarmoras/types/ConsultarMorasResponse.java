
package com.bancodebogota.consultarmoras.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarMorasResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarMorasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/}respuestaConsultaMoras" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarMorasResponse", propOrder = {
    "_return"
})
public class ConsultarMorasResponse {

    @XmlElement(name = "return")
    protected RespuestaConsultaMoras _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConsultaMoras }
     *     
     */
    public RespuestaConsultaMoras getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConsultaMoras }
     *     
     */
    public void setReturn(RespuestaConsultaMoras value) {
        this._return = value;
    }

}


package com.bancodebogota.consultarmoras;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.bancodebogota.consultarmoras.types.ObjectFactory;
import com.bancodebogota.consultarmoras.types.RespuestaConsultaMoras;


/**
 * This class was generated by the JAX-WS RI.
 * Oracle JAX-WS 2.1.5
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ConsultarMorasModelBean", targetNamespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConsultarMorasModelBean {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.bancodebogota.consultarmoras.types.RespuestaConsultaMoras
     * @throws Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarMoras", targetNamespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", className = "com.bancodebogota.consultarmoras.types.ConsultarMoras")
    @ResponseWrapper(localName = "consultarMorasResponse", targetNamespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", className = "com.bancodebogota.consultarmoras.types.ConsultarMorasResponse")
    public RespuestaConsultaMoras consultarMoras(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception
    ;

}
